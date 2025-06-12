package panda.sample.apidemo.restservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author panda
 */

@Entity
public class ProductDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String producer;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {

        return producer;
    }

    public ProductDescription() {
    }

    public ProductDescription(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    /*
     * private Boolean isPretty() {
     * if (this.id == 0)
     * return false;
     * if (this.name == null)
     * return false;
     * if (this.producer == null)
     * return false;
     * return true;
     * }
     */

}
