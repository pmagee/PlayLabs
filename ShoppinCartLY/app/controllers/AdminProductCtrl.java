package controllers;

import controllers.security.*;

import play.mvc.*;
import play.api.Environment;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


import models.users.*;
import models.products.*;
import views.html.productAdmin.*;

import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.FilePart;
import java.io.File;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

// Authenticate user
@Security.Authenticated(Secured.class)
// Authorise user (check if admin)
@With(CheckIfAdmin.class)

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class AdminProductCtrl extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    private FormFactory formFactory;
    private Environment e;
    
    @Inject
    public AdminProductCtrl(FormFactory f,Environment env) {
        this.formFactory = f;
        this.e = env;
    }
        // Get a user - if logged in email will be set in the session
	private User getCurrentUser() {
		User u = User.getLoggedIn(session().get("email"));
		return u;
	}
    public Result index() {
        return redirect(controllers.routes.AdminProductCtrl.listProducts(0));
    }
    // Get a list of products
    // If cat parameter is 0 then return all products
    // Otherwise return products for a category (by id)
    // In both cases products will be searched using the fiter value
    @Transactional
    public Result listProducts(Long cat) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products			
        List<Product> products = new ArrayList<Product>();
    
        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll();
        }else {
            products = Category.find.ref(cat).getProducts();
        }

        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(listProducts.render(products, categories, getCurrentUser(),e));
    }

    @Transactional
    public Result addProduct() {
        Form<Product> addProductForm = formFactory.form(Product.class);
        return ok(addProduct.render(addProductForm, getCurrentUser()));
    }
    @Transactional
    public Result addProductSubmit() {
        Product newProduct;
        String saveImageMsg;
        Form<Product> newProductForm = formFactory.form(Product.class).bindFromRequest();

        if (newProductForm.hasErrors()) {
            return badRequest(addProduct.render(newProductForm, 
            getCurrentUser()));
        }
        else {
             newProduct = newProductForm.get();

        
                // Save the object to the Products table in the database
                newProduct.save();
                                // Get category ids (checked boxes from form)
                    // Find category objects and set categories list for this product
                    for (Long cat : newProduct.getCatSelect()) {
                        newProduct.categories.add(Category.find.byId(cat));
                    }
                newProduct.update();
        }
        MultipartFormData data = request().body().asMultipartFormData();
        FilePart<File> image = data.getFile("upload");

        saveImageMsg = saveFile(newProduct.getId(), image);

        flash("success", "Product " + newProduct.getName() + " has been created/updated " + saveImageMsg);

        return redirect(controllers.routes.AdminProductCtrl.index());
    }
    
   
    @Transactional
    public Result deleteProduct(Long id) {
        Product.find.ref(id).delete();

        flash("success", "Product has been deleted");
        
        return redirect(routes.AdminProductCtrl.index());
    }


    @Transactional
    public Result updateProduct(Long id) {
        Product p;
        Form<Product> productForm;

        try {
            p = Product.find.byId(id);
            productForm = formFactory.form(Product.class).fill(p);
        } 
        catch (Exception ex) {
            return badRequest("error");
        }
        return ok(updateProduct.render(id, productForm,getCurrentUser()));
    }

    @Transactional
   public Result updateProductSubmit(Long id) {
    String saveImageMsg;
        
                // Retrieve the submitted form object (bind from the HTTP request)
                Form<Product> updateProductForm = formFactory.form(Product.class).bindFromRequest();
        
                // Check for errors (based on constraints set in the Product class)
                if (updateProductForm.hasErrors()) {
                    // Display the form again by returning a bad request
                    return badRequest(updateProduct.render(id,updateProductForm, getCurrentUser()));
                } else {
                    // No errors found - extract the product detail from the form
                    Product p = updateProductForm.get();
                    p.setId(id);                    
                    
                    // Get category ids (checked boxes from form)
                    // Find category objects and set categories list for this product
                    List<Category> newCats = new ArrayList<Category>();
                    for (Long cat : p.getCatSelect()) {
                        newCats.add(Category.find.byId(cat));
                    }
                    p.categories = newCats;
                    //update (save) this product
                    p.update();
        
                    MultipartFormData data = request().body().asMultipartFormData();
                    FilePart<File> image = data.getFile("upload");
        
                    saveImageMsg = saveFile(p.getId(), image);
        
                    flash("success", "Product " + p.getName() + " has been created/updated " + saveImageMsg);
                    
                    // Redirect to the admin home
                    return redirect(controllers.routes.AdminProductCtrl.index());
                }
            }

            

    public String saveFile(Long id, FilePart<File> uploaded) {
        // make sure that the file exists
        if (uploaded != null) {
            // make sure that the content is indeed an image
            String mimeType = uploaded.getContentType(); 
            if (mimeType.startsWith("image/")) {
                // get the file name
                String fileName = uploaded.getFilename();                
                // save the file object (created without a path, File saves
                // the content to a default location, usually the temp or tmp
                // directory)
                File file = uploaded.getFile();
                // create an ImageMagik operation - this object is used to specify
                // the required image processing
                IMOperation op = new IMOperation();
                // add the uploaded image to the operationop.addImage(file.getAbsolutePath());
                op.addImage(file.getAbsolutePath());
                // resize the image using height and width saveFileOld(Long id, FilePart<File> uploaded) {
                op.resize(300, 200);
                // save the image as jpg 
                op.addImage("public/images/productImages/" + id + ".jpg");
                // create another Image Magick operation and repeat the process above to
                // specify how a thumbnail image should be processed - size 60px
                IMOperation thumb = new IMOperation();
                thumb.addImage(file.getAbsolutePath());
                thumb.resize(60);
                thumb.addImage("public/images/productImages/thumbnails/" + id + ".jpg");
                // we must make sure that the directories exist before running the operations
                File dir = new File("public/images/productImages/thumbnails/");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // now we create an Image Magick command and execute the operations
                ConvertCmd cmd = new ConvertCmd();
                try {
                    cmd.run(op);
                    cmd.run(thumb);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                return " and image saved";
            }
        }
        return "/ no file";
    }
    public String saveFileOld(Long id, FilePart<File> uploaded) {
        // make sure that the file exists
        String mimeType = uploaded.getContentType(); 
        if (uploaded != null) {
            // make sure that the content is indeed an image
            if (mimeType.startsWith("image/")) {
                // get the file name
                String fileName = uploaded.getFilename();      
                String extension = "";
                int i = fileName.lastIndexOf('.');
                if (i >= 0) {
                    extension = fileName.substring(i+1);
                }
                // save the file object (created without a path, File saves
                // the content to a default location, usually the temp or tmp
                // directory)
                File file = uploaded.getFile();
                // we must make sure that the directory for the images exists before we save it
                File dir = new File("public/images/productImages");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // move the file to the required location (in a real application 
                // the path to where images are stored would be configurable, but 
                // for the lab we just hard-code it)
                if(file.renameTo(new File("public/images/productImages/", id + "." + extension))) {
                    return "/ file uploaded";
                } else {
                    return "/ file upload failed";
                }
            }
        }
        return "/ no file";
    }

    
}