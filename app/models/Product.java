package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity

public class Product extends Model {

    //Properties
    
    @Id
    private Long  id;
   
    @Constraints.Required
    private String name;

    @ManyToOne
    private Category category;
   
    @Constraints.Required
    private String description;
   
    @Constraints.Required
    private int stock;
   
    @Constraints.Required
    private double price;

    //Default constructor
    public Product() {

    }
    //Constructor to initialise object
    public Product(Long id, String name, String description, int stock, double price){
        this.id=id;
        this.name=name;
        this.description=description;
        this.stock=stock;
        this.price=price;
    }

    //Accessor methods
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

   public void setName(String name) {
       this.name=name;
   }

   public void setDescription(String description) {
    this.description=description;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public void setStock(int stock) {
        this.stock=stock;
    }

    public void setPrice(double price) {
        this.price=price;
    }


//noch mit in der klammer oder nicht?
public static final Finder<Long, Product> find = new Finder<>(Product.class);

public static final List<Product> findAll(){
    return Product.find.all();
}
}