package org.example.orderApp.controller;


import org.example.common.enums.ResponseCode;
import org.example.orderApp.model.Item;
import org.example.orderApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("api/item")

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("list")
    public ResponseEntity<List<Item>> helloWorld() {
        List<Item> items = itemRepository.findAll();
        return ResponseEntity.status(ResponseCode.SUCCESS.getCode()).body(items);
    }


}
