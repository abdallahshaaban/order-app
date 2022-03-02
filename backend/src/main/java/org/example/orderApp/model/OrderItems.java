package org.example.orderApp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="Order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="item_id")
    private int itemId;
    @Column(name="order_id")
    private int orderId;

    private int quantity;

    private Double price;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Item item;
}
