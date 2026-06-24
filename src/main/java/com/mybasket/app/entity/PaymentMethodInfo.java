package com.mybasket.app.entity;

import jakarta.persistence.*;
import org.hibernate.engine.profile.Fetch;

@Entity
@Table(name = "my-basket-payment-method-info")
public class PaymentMethodInfo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @OneToOne
   private Payment payment;

   @ManyToOne(fetch = FetchType.LAZY)
   private User user;

   @Embedded
   private UPI upi;

//   private Card card;
//   private NetBanking netBanking;

@Embedded
   private Cod cod;

 }
