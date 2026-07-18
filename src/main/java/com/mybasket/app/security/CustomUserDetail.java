package com.mybasket.app.security;

import com.mybasket.app.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class CustomUserDetail implements UserDetails
{

    private User user;

    public CustomUserDetail(User user){
        //    aapke user ki  information
        this.user = user;
    }


    //  role based  authentication k liye
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        ROLE role = user.getRole();
//        Collection roleCollection = new ArrayList();
//        roleCollection.add(new SimpleGrantedAuthority(role.toString()));
//        return roleCollection;


        return List.of(new SimpleGrantedAuthority(user.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }


}
