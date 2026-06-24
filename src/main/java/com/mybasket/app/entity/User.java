package com.mybasket.app.entity;


import jakarta.persistence.*;
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

    private String userImageUrl;


// one user se many addesses nikl sakte hai
//    orm iska bhi new table create kr de rha hai to redudency aagya
//    to yaddi mapppedBy user se kr de to ek hi tble se km ho jayega
    @OneToMany(mappedBy = "user")
    private Set<Address>addresses = new HashSet<>();


@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
private Set<PaymentMethodInfo> paymentMethodInfos = new LinkedHashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }
}
