package panda.sample.apidemo.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import panda.sample.apidemo.restservice.model.ProductDescription;
import panda.sample.apidemo.restservice.repository.ProductDescriptionRepository;

@Service
public class CatalogService {
    @Autowired
    private ProductDescriptionRepository productRepository;

    public Iterable<ProductDescription> getProductDescriptions() {
        return productRepository.findAll();
    }

    public ProductDescription addProductDescription(String name, String producer) {
        ProductDescription ProductDescription = new ProductDescription(name, producer);
        productRepository.save(ProductDescription);
        return ProductDescription;
    }

    public void deleteProductDescription(Integer id) {
        productRepository.deleteById(id);
    }
}
