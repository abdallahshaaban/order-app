package org.example.login.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
}
