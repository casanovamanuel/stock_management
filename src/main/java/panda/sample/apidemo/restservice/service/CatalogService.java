package panda.sample.apidemo.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import panda.sample.apidemo.restservice.model.Product;
import panda.sample.apidemo.restservice.repository.ProductRepository;

@Service
public class CatalogService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(String name, String producer) {
        Product product = new Product(name, producer);
        productRepository.save(product);
        return product;
    }
}
