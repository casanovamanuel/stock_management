package panda.sample.apidemo.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import panda.sample.apidemo.restservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

}
