package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.Inject;

import views.html.*;
import play.db.ebean.Transactional;
import play.api.Environment;

// Import models
import models.users.*;
import models.products.*;
import models.shopping.*;

// Import security controllers
// import controllers.security.*;

// Authenticate user
@Security.Authenticated(Secured.class)
// Authorise user (check if user is a customer)
@With(CheckIfCustomer.class)

public class ShoppingCtrl extends Controller {


    /** Dependency Injection **/

    /** http://stackoverflow.com/questions/15600186/play-framework-dependency-injection **/
    private FormFactory formFactory;

    /** http://stackoverflow.com/a/37024198 **/
    private Environment env;

    /** http://stackoverflow.com/a/10159220/6322856 **/
    @Inject
    public ShoppingCtrl(Environment e, FormFactory f) {
        this.env = e;
        this.formFactory = f;
    }


    
    // Get a user - if logged in email will be set in the session
	// private Customer getCurrentUser() {
	// 	return (Customer)User.getUserById(session().get("email"));
    // }
    

    @Transactional
    public Result showBasket() {
        return ok(basket.render((Customer)User.getUserById(session().get("email"))));
    }
    
    // Add item to customer basket
    @Transactional
    public Result addToBasket(Long id) {
        
        // Find the item on sale
        ItemOnSale item = ItemOnSale.find.byId(id);
        
        // Get basket for logged in customer
        Customer customer = (Customer)User.getUserById(session().get("email"));
        
        // Check if item in basket
        if (customer.getBasket() == null) {
            // If no basket, create one
            customer.setBasket(new Basket());
            customer.getBasket().setCustomer(customer);
            customer.update();
        }
        // Add product to the basket and save
        customer.getBasket().addItemOnSale(item);
        customer.update();

        //update stock
        item.decrementStock();
        item.update();
        
        // Show the basket contents     
        return ok(basket.render(customer));
    }
    
    // Add an item to the basket
    @Transactional
    public Result addOne(Long itemId, Long pid) {
        
        // Get the order item
        OrderItem item = OrderItem.find.byId(itemId);

        ItemOnSale ios = ItemOnSale.find.byId(pid);

        if(ios.getStock()>0){
            // Increment quantity
            item.increaseQty();
            // Save
            item.update();
            ios.decrementStock();
            ios.update();
        }else{
            flash("error", "Sorry, no more of these items left");
        }
        // Show updated basket
        return redirect(routes.ShoppingCtrl.showBasket());
    }

    @Transactional
    public Result removeOne(Long itemId,Long pid) {
        
        // Get the order item
        OrderItem item = OrderItem.find.byId(itemId);

        ItemOnSale ios = ItemOnSale.find.byId(pid);
        // Get user
        Customer c = (Customer)User.getUserById(session().get("email"));
        // Call basket remove item method
        c.getBasket().removeItem(item,ios);
        c.getBasket().update();
        // back to basket
        return ok(basket.render(c));
    }

    // Empty Basket
    @Transactional
    public Result emptyBasket() {
        
        Customer c = (Customer)User.getUserById(session().get("email"));
        c.getBasket().removeAllItems();
        c.getBasket().update();
        
        return ok(basket.render(c));
    }

    @Transactional
    public Result placeOrder() {
        Customer c = (Customer)User.getUserById(session().get("email"));
        
        // Create an order instance
        ShopOrder order = new ShopOrder();
        
        // Associate order with customer
        order.setCustomer(c);
        
        // Copy basket to order
        order.setItems(c.getBasket().getBasketItems());
        
        // Save the order now to generate a new id for this order
        order.save();
       
       // Move items from basket to order
        for (OrderItem i: order.getItems()) {
            // Associate with order
            i.setOrder(order);
            // Remove from basket
            i.setBasket(null);
            // update item
            i.update();
        }
        
        // Update the order
        order.update();
        
        // Clear and update the shopping basket
        c.getBasket().setBasketItems(null);
        c.getBasket().update();
        
        // Show order confirmed view
        return ok(orderConfirmed.render(c, order));
    }
    
    // View an individual order
    @Transactional
    public Result viewOrder(long id) {
        ShopOrder order = ShopOrder.find.byId(id);
        return ok(orderConfirmed.render((Customer)User.getUserById(session().get("email")), order));
    }

}