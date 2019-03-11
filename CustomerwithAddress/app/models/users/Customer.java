package models.users;

import models.shopping.*;
import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;



@Table(name = "user")
// This is a Customer of type admin
@DiscriminatorValue("c")

// Customer inherits from the User class
@Entity
public class Customer extends User{
    
    @Constraints.Required
    private String creditCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="AID")
    private Address address;
    
    @OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
    private Basket basket;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<ShopOrder> orders;

    public Customer(){

    }
	
    public Customer(String email, String role, String name, String password,Date dateOfBirth)
	{
		super(email, role, name, password,dateOfBirth);
        
	}

    

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    public static final Finder<Long, Customer> find = new Finder<>(Customer.class);
			    
    public static final List<Customer> findAll() {
       return Customer.find.all();
    }
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Address getAddress(){
        return address;
    }
    public void setAddress(Address a){
        this.address = a;
    }

    public List<ShopOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ShopOrder> orders) {
        this.orders = orders;
}
}