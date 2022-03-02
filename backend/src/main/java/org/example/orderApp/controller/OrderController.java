package org.example.orderApp.controller;


import org.example.common.enums.ResponseCode;
import org.example.login.model.User;
import org.example.login.repository.UserRepository;
import org.example.orderApp.dto.AddToCartDto;
import org.example.orderApp.model.Item;
import org.example.orderApp.model.Order;
import org.example.orderApp.repository.OrderRepository;
import org.example.orderApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/order")

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderService orderService;
    @GetMapping("list")
    public ResponseEntity<List<Order>> list() {
        String username  = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        User user = userRepository.findByName(username);
        List<Order> orders = orderRepository.findByUserIdAndStatus(user.getId(),"inProgress");
        return ResponseEntity.status(ResponseCode.SUCCESS.getCode()).body(orders);
    }
    @PostMapping("addToCart")
    public  ResponseEntity<Order> addToCard(@RequestBody AddToCartDto addToCartDto){
        String username  = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        User user = userRepository.findByName(username);
        Order Order = orderService.addToCart(user,addToCartDto);

        return ResponseEntity.status(ResponseCode.SUCCESS.getCode()).body(Order);
    }

}