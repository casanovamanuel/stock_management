package panda.sample.apidemo.restservice.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import panda.sample.apidemo.restservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}