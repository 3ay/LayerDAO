package com.netology.layerdao.dao;

import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@ToString
public class OrdersDAO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersDAO customer;
    private int age;
    @Column(name = "product_name")
    private String productName;
    private String amount;

}
