package org.example.orderApp.service;


import org.example.login.model.User;
import org.example.orderApp.dto.AddToCartDto;
import org.example.orderApp.model.Item;
import org.example.orderApp.model.Order;
import org.example.orderApp.model.OrderItems;
import org.example.orderApp.repository.ItemRepository;
import org.example.orderApp.repository.OrderItemsRepository;
import org.example.orderApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    ItemRepository itemRepository;

    public Order addToCart(User user, AddToCartDto addToCartDto){
        Order order = getInProgressOrderForUser(user);
        OrderItems orderItem = getOrderItem(order,addToCartDto);
        return order;
    }

    private OrderItems getOrderItem(Order order , AddToCartDto addToCartDto){
        OrderItems orderItem = new OrderItems();

        Optional<OrderItems> orderItemOpt = orderItemsRepository.findByOrderIdAndItemId(order.getId(),addToCartDto.getItemId());
        Optional<Item> item = itemRepository.findById(addToCartDto.getItemId());
        if(orderItemOpt.isPresent()){
            orderItem = orderItemOpt.get();
            int quantity =orderItem.getQuantity()+addToCartDto.getQuantity();
            orderItem.setQuantity(quantity);
            orderItem.setPrice(quantity*item.get().getPrice());
            updateOrderTotalPrice(order,addToCartDto.getQuantity()*item.get().getPrice());

            orderItemsRepository.save(orderItem);

        }else{
            orderItem.setOrderId(order.getId());
            orderItem.setItemId(addToCartDto.getItemId());
            orderItem.setQuantity(addToCartDto.getQuantity());
            orderItem.setPrice(addToCartDto.getQuantity()*item.get().getPrice());
            updateOrderTotalPrice(order,addToCartDto.getQuantity()*item.get().getPrice());

            orderItemsRepository.save(orderItem);
        }
        return orderItem;
    }
    private Order getInProgressOrderForUser(User user){
        List<Order> orders = orderRepository.findByUserIdAndStatus(user.getId(),"inProgress");
        Order order = new Order();
        if(orders.size() == 0){
            order.setUserId(user.getId());
            order.setStatus("inProgress");
            order.setTotal_price(0.0);
            orderRepository.save(order);
        }else{
            order = orders.get(0);
        }
        return order;
    }

    private void updateOrderTotalPrice(Order order , Double price){
        Double newPrice = order.getTotal_price()+price;
        order.setTotal_price(newPrice);
        orderRepository.save(order);
    }

}
