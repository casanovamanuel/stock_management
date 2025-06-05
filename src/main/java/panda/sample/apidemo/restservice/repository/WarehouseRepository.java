package panda.sample.apidemo.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import panda.sample.apidemo.restservice.model.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

}
