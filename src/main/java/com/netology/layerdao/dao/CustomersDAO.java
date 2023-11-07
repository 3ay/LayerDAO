package com.netology.layerdao.dao;

import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@ToString
public class CustomersDAO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdersDAO> orders = new ArrayList<>();
}
