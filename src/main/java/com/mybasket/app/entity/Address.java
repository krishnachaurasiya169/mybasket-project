package com.mybasket.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my-basket-address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String pincode;


//    means ek address se koi ek user nikl sakte h
//    this is resposible for foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

}
