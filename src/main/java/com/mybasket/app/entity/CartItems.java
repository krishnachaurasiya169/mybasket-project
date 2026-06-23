package com.mybasket.app.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="my-basket-cart-items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    private int quantity;

//    ek product bahut sare CartItem me aa sakta hai
//    means  kai  sare users k pass  cart me ek ki product ho  sakta hai

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

//    ek cart me many cartItem hoga
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

}
