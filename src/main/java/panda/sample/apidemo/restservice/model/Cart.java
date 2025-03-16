package panda.sample.apidemo.restservice.model;

public class Cart {
    private String owner = "panda";
    private Product[] products = new Product[] {};

    public String getOwner() {
        return owner;
    }

    public Cart setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Product[] getProducts() {
        return products;
    }
}
