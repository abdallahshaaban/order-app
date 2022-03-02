package org.example.orderApp.repository;


import org.example.orderApp.model.Item;
import org.example.orderApp.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findAll();
    Optional<Item> findById(int id);
}
