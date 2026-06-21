package com.mybasket.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ye soch lo ki ue class ek table se mapp hai

//entity means jo ye class hai wo entity hai
@Entity

//@table means is table ka name jpa_user hai id we not use table anoootation then table name by default class name hota hai
@Table(name="my-basket-users")
public class User {

//    @Id means ye column primary key hai
    @Id

//    @Column se is column ka name hoga (jpa_user_id) but yaha pr userId use kaenge
    @Column(name="jpa_user_id")
    private int userId;


    private String name;

    @Column(unique = true,length = 100)
    private String email;

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
}
