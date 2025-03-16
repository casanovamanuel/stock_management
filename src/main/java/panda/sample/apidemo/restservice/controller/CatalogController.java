package panda.sample.apidemo.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import panda.sample.apidemo.restservice.model.Product;
import panda.sample.apidemo.restservice.service.CatalogService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    public static class ProductFacade { // necesario para reducir la información enviada
        private String name;
        private String producer;

        public ProductFacade() {
        }

        public ProductFacade(String name, String producer) {
            this.name = name;
            this.producer = producer;
        }

        public ProductFacade(Product p) {
            this.name = p.getName();
            this.producer = p.getProducer();
        }

        public String getName() {
            return name;
        }

        public String getProducer() {
            return producer;
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductFacade>> getProducts(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "producer", required = false) String producer) {
        Iterable<Product> products = catalogService.getProducts();
        List<ProductFacade> pf = new java.util.ArrayList<ProductFacade>();
        products.forEach((element) -> {
            pf.add(new ProductFacade(element));
        });

        return ResponseEntity.ok(pf);
    }

    @PostMapping("/new")
    public Product addProduct(@RequestBody ProductFacade entity) {
        Product product = catalogService.addProduct(entity.name, entity.producer);
        return product;
    }

}
