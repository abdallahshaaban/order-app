package org.example.orderApp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="Item")
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    public Item() {
    }

    public Item(String name,Double price){
        this.name = name;
        this.price = price;
    }
}
