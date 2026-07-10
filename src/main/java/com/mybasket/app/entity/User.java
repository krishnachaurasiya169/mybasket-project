package com.mybasket.app.entity;


import com.mybasket.app.security.ROLE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//ye soch lo ki ue class ek table se mapp hai

//entity means jo ye class hai wo entity hai
@Entity

//softdelete hua h
@SQLDelete(sql = "update `my-basket-users` set deleted = true where jpa_user_id = ? ")
@SQLRestriction(" deleted = false ")

// @table means is table ka name jpa_user hai id we not use table annotation then table name by default class name hota hai
@Table(name="my-basket-users")

@Getter
@Setter
@AllArgsConstructor

public class User extends BaseEntity {

//    @Id means ye column primary key hai
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column se is column ka name hoga (jpa_user_id) but yaha pr userId use kaenge
    @Column(name="jpa_user_id")
    private int userId;


    private String name;

    @Column(unique = true,length = 100)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private ROLE role = ROLE.ROLE_NORMAL;


// one user se many addesses nikl sakte hai
//    orm iska bhi new table create kr de rha hai to redudency aagya
//    to yaddi mapppedBy user se kr de to ek hi tble se km ho jayega
    @OneToMany(mappedBy = "user")
    private Set<Address>addresses = new HashSet<>();


   @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
   private Set<PaymentMethodInfo> paymentMethodInfos = new LinkedHashSet<>();


}
