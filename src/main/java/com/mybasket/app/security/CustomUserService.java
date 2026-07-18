package com.mybasket.app.security;

import com.mybasket.app.entity.User;
import com.mybasket.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomUserService implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      fetch user from the database
//      user repo me sb rahga
        User user = userRepository.findByEmail(username).orElseThrow(()-> new BadCredentialsException("username or password invalid"));
        UserDetails userDetails = new CustomUserDetail(user);
        return userDetails;
    }
}
