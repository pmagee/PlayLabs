package controllers;

import play.mvc.*;
import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


import models.users.*;
import models.products.*;
import views.html.*;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ProductCtrl extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    private FormFactory formFactory;
    private Environment e;
    
    @Inject
    public ProductCtrl(FormFactory f,Environment env) {
        this.formFactory = f;
        this.e = env;
        }
    // Get a user - if logged in email will be set in the session
    @Transactional
	public User getCurrentUser() {
		User u = User.getLoggedIn(session().get("email"));
		return u;
	}
    public Result index() {
        return redirect(routes.ProductCtrl.listProducts(0,""));
    }

    // Get a list of products
    // If cat parameter is 0 then return all products
    // Otherwise return products for a category (by id)
    // In both cases products will be searched using the fiter value
    @Transactional
    public Result listProducts(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products			
        List<Product> products = new ArrayList<Product>();
    
        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(listProducts.render(products,categories, cat, filter, getCurrentUser(),e));
    }
    public Result productDetails(Long id) {
        Product p;

        p = Product.find.byId(id);

        return ok(productDetails.render(p,User.getLoggedIn(session().get("email")),e));
    }
    
}