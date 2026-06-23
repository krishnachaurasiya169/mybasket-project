package com.mybasket.app.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "my-basket-orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
//ek order many user k ho sakte hai , lazy means when we fetch then user comes other wise not comes
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

//ek address pr many order ho sakte hai
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

//    database k under string type me store hoga
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PLACED;


    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    private Payment payment;
}
