package com.mybasket.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


//means this class extends to the another entity
@MappedSuperclass

@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {

    @Column(nullable = false)
    private boolean deleted = false;


//    jb entity create hoga usii date aayega
    @CreatedDate
//    updatable false hai means ek baar entity create the not change
    @Column(updatable = false)
    private LocalDateTime createAt;


//    jb last change hua hoga tb LastmodifiedDate ki help se wo date aayega updateAt me
    @LastModifiedDate
    private  LocalDateTime updateAt;


}
