package org.example.login.repository;

import org.example.login.model.User;
import org.example.orderApp.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByNameAndPassword(String name, String password);
    User findByName(String name);

}
