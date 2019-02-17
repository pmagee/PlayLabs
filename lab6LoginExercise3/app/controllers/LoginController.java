package controllers;

import play.mvc.*;

import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import models.users.*;

import views.html.*;

public class LoginController extends Controller {
    private FormFactory formFactory;
 
    @Inject
    public LoginController(FormFactory f) {
        this.formFactory = f;
    }
    
    public Result login() {
        Form<Login> loginForm = formFactory.form(Login.class);
        return ok(login.render(loginForm,User.getUserById(session().get("email"))));
}
public Result loginSubmit() {
    Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();

    if (loginForm.hasErrors()) {
        return badRequest(login.render(loginForm,User.getUserById(session().get("email"))));
    } else {
        // Up to here, the logic is the same as in the addItemSubmit() action
        // method of the HomeController. However, while the data from the item 
        // form was used to create an entry in the corresponding database table,
        // here the data is not stored but rather its successful validation used
        // as a prompt for the beginning of a new session.

        // Clear any existing session
        session().clear();

        // Store the logged-in email in a cookie i.e. start a new session
        session("email", loginForm.get().getEmail());

        return redirect(controllers.routes.HomeController.index());
    }
}
public Result logout() {
    // To log the user out, we just delete the current session
    session().clear();
    flash("success", "You have been logged out");
    return redirect(routes.LoginController.login());
}

public Result registerUser() {
    Form<User> userForm = formFactory.form(User.class);
    return ok(registerUser.render(userForm,User.getUserById(session().get("email"))));
}

public Result registerUserSubmit() {
// We use the method bindFromRequest() to populate our Form<ItemOnSale> object with the
// data that the user submitted. Thanks to Play Framework, we do not need to do the messy
// work of parsing the request and extracting data from it characte by character.
Form<User> newUserForm = formFactory.form(User.class).bindFromRequest();
// We check for errors (based on constraints set in ItemOnSale class)
if (newUserForm.hasErrors()) {
    // If the form data have errors, we call the method badRequest(), requesting Play 
    // Framework to send an error response to the user and display the additem page again. 
    // As we are passing in newItemForm, the form will be populated with the data that the 
    // user has already entered, saving them from having to enter it all over again.
    return badRequest(addUser.render(newUserForm,User.getUserById(session().get("email"))));
} else {
    // If no errors are found in the form data, we extract the data from the form.
    // Form objects have handy utility methods, such as the get() method we are using 
    // here to extract the data into an ItemOnSale object. This is possible because
    // we defined the form in terms of the model class ItemOnSale.
    User newUser = newUserForm.get();
    // Now we call the ORM method save() on the model object, to have it saved in the
    // database as a line in the table item_on_sale.
    System.out.println("Name" +newUser.getName());
    System.out.println("Role" +newUser.getRole());

    if(User.getUserById(newUser.getEmail())==null){
        newUser.save();
    }else{
        newUser.update();
    }
    // We use the flash scope to specify that we want a success message superimposed on
    // the next displayed page. The flash scope uses cookies, which we can read and set
    // using the flash() function of the Play Framework. The flash scope cookies last
    // for a single request (unlike session cookies, which we will use for log-in in a
    // future lab). So, add a success message to the flash scope.
    flash("success", "User " + newUser.getName() + " was added/updated.");
    // Having specified we want a message at the top, we can redirect to the onsale page,
    // which will have to be modified to read the flash scope and display it.
    return redirect(controllers.routes.LoginController.login()); 
    }
}


}