package com.mybasket.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my-basket-payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;
    @Enumerated(EnumType.STRING)
    private PaymentMethod method = PaymentMethod.COD;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(mappedBy = "payment")
    private PaymentMethodInfo paymentMethodInfo;

    @OneToOne(mappedBy = "payment")
    private Order order;
}
