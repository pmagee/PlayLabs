package controllers;

import play.mvc.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import models.users.*;

// More information about Action.Simple:
// https://alexgaribay.com/2014/06/15/authentication-in-play-framework-using-java/

// Similarly to Security.Authenticator (base class of our class Secured), the Action.Simple
// class allows us to intercept a request and do something. 

// The Security.Authenticator does a very specific thing, looking for a username to continue.
// The Action.Simple class as a base allows us to create a custom action and associate it 
// with any method in our application. Actions use asynchronous Java programming, which uses 
// promises of a future result (CompletionStage<Result> and CompletableFuture).
public class AuthAdmin extends Action.Simple {

    public CompletionStage<Result> call(Http.Context ctx) {

        String id = ctx.session().get("email");
        if (id != null) {
            User u = User.getUserById(id);
            if ("admin".equals(u.getRole())) {
                // Call the intercepted action method
                return delegate.call(ctx);
            }
        }
        ctx.flash().put("error", "Administrator login required");
        // Redirect to the login page
        return CompletableFuture.completedFuture(redirect(routes.LoginController.login()));
    }
}
