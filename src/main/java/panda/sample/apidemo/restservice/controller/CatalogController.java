package panda.sample.apidemo.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import panda.sample.apidemo.restservice.model.ProductDescription;
import panda.sample.apidemo.restservice.service.CatalogService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    public static class ProductDescriptionFacade { // necesario para reducir la información enviada
        private String name;
        private String producer;

        public ProductDescriptionFacade() {
        }

        public ProductDescriptionFacade(String name, String producer) {
            this.name = name;
            this.producer = producer;
        }

        public ProductDescriptionFacade(ProductDescription p) {
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
    public ResponseEntity<List<ProductDescriptionFacade>> getProductDescriptions(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "producer", required = false) String producer) {
        Iterable<ProductDescription> ProductDescriptions = catalogService.getProductDescriptions();
        List<ProductDescriptionFacade> pf = new java.util.ArrayList<ProductDescriptionFacade>();
        ProductDescriptions.forEach((element) -> {
            pf.add(new ProductDescriptionFacade(element));
        });

        return ResponseEntity.ok(pf);
    }

    @PostMapping("/new")
    public ProductDescription addProductDescriptionDescription(
            @RequestBody ProductDescriptionFacade entity) {
        ProductDescription ProductDescription = catalogService.addProductDescription(entity.name, entity.producer);
        return ProductDescription;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductDescription(@PathVariable Integer id) {
        catalogService.deleteProductDescription(id);
    }

}
