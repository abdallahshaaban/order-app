package org.example.orderApp.repository;


import org.example.orderApp.model.Item;
import org.example.orderApp.model.OrderItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderId(int orderId);
    Optional<OrderItems> findByOrderIdAndItemId(int orderId,int itemId);

}
