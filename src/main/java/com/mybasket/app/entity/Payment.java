package com.mybasket.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my-basket-payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;




    @OneToOne(mappedBy = "order_id")
    private Order order;


    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;
    @Enumerated(EnumType.STRING)
    private PaymentMethod method = PaymentMethod.COD;

    @OneToOne(mappedBy = "payment")
    private PaymentMethodInfo paymentMethodInfo;
}
