package models.products;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Category extends Model {
    @Id
    private Long id;
    
    @Constraints.Required
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public Category() {
    }

    public Category(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Finder<Long, Category> find = new Finder<Long, Category>(Category.class);

    public static List<Category> findAll() {
        return Category.find.query().where().orderBy("name asc").findList();
    }

    public static Map<String, String> options() {
        LinkedHashMap<String, String> options = new LinkedHashMap();

        for (Category c: Category.findAll()) {
            options.put(c.getId().toString(), c.getName());
        }
        
        return options;
    }
            // Check if a product is in a category
            public static boolean inCategory(Long category, Long product) {
                return find.query().where()
                    .eq("products.id", product)
                    .eq("id", category)
                    .findCount() > 0;
            }

}