package org.example.orderApp.model;

import lombok.Data;
import org.example.login.model.User;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name ="Order_Table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;
    @Column(name="total_Price")
    private Double total_price;
    private String status;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false,updatable = false)
    private List<OrderItems> orderItems;

}
