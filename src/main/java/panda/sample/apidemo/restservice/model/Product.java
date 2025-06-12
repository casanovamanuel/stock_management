package panda.sample.apidemo.restservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author panda
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private ProductDescription description;

    public int getId() {
        return id;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public Product() {
    }

    public Product(ProductDescription newDescription) {
        this.description = newDescription;
    }

    /*
     * private Boolean isPretty() {
     * if (this.id == 0)
     * return false;
     * if (this.description == null)
     * return false;
     * return true;
     * }
     */

}