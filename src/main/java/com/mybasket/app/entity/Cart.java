package com.mybasket.app.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="my-basket-cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private double totalAmount;

    private int totalItems;

    @OneToOne
    private User user;

//    ek cart k under multiple cartItem hai toh cart k bare me socho
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItems> cartItems=new ArrayList<>();
}
