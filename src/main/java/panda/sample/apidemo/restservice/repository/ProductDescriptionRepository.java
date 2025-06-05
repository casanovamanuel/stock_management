package panda.sample.apidemo.restservice.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import panda.sample.apidemo.restservice.model.ProductDescription;

public interface ProductDescriptionRepository extends CrudRepository<ProductDescription, Integer> {

}