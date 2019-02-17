package models.users;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;





@Entity
public class User extends Model {

    // Properties
    @Id
    private String email;

    @Constraints.Required
    private String role;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String password;

    public static final Finder<Long, User> find = new Finder<>(User.class);

    // Default Constructor
    public User() {
    }

    // Constructor to initialise object
    public User(String email, String role, String name, String password) {
        this.email = email;
        this.role = role;
        this.name = name;
        this.password = password;
    }


     public static List<User> findAll() {
        return User.find.query().where().orderBy("name asc").findList();
     }


     public static User authenticate(String email, String password) {
        return find.query().where().eq("email", email).eq("password", password).findUnique();
     }

     public static User getUserById(String id) {
         if (id == null) {
             return null;
         } else {
             return find.query().where().eq("email", id).findUnique();
         }
     }

    // Accessor methods
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}