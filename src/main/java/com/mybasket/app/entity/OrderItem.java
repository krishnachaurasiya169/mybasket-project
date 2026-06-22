package com.mybasket.app.entity;


import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="my-basket-order-items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    order item me  many product ho sakte hai na
    @ManyToOne
    private Product product;

    private Integer Quantity;


    @ManyToOne
    private Order order;


}
