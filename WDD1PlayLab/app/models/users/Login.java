package models.users;

// This class serves as the blueprint for the log-in HTML form
public class Login {
    private String email;
    private String password;


    // We define a validate method, which will be used for the
    // validation of form data by the framework )the name of the
    // validation method must be exactly 'validate', it must not
    // have any parameters and return a String, because it is
    // a method with that signature that the framework looks for
    // to use as the form data error checker). Also, the way the
    // method should work is to return a null if there are no errors
    // and to return an error message in a String object if there
    // ARE errors
    public String validate() {
        // We call the authenticate method in class User
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }


    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}