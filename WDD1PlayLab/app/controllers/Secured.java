package controllers;

import play.mvc.*;
import play.mvc.Http.*;


// This class is put into action when access to paths
// that need authorisation is attempted
public class Secured extends Security.Authenticator {

    // Get the email (username) of the logged-in uder
    // or null if no user is logged in
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }
    

    // This method defines a behaviour invoked when
    // a user tries to access a page but is not logged in -
    // we tell it to redirect to the login pahe
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(controllers.routes.LoginController.login());
    }
}