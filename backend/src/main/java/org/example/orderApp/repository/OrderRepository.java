package org.example.orderApp.repository;

import org.example.orderApp.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();
    List<Order> findByUserIdAndStatus(int user_id,String status);

}
