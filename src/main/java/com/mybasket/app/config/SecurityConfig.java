package com.mybasket.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//      UserDetails user1 = User.builder().username("aditya").password("{noop}abc").build();
//      UserDetails user2 = User.builder().username("aman").password("{noop}def").build();
//        return new InMemoryUserDetailsManager(user1);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        Customization
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        requests ->
//                                ye hmra ek tarah se private hai
//                                requests.requestMatchers(HttpMethod.GET).permitAll()
//                                        .requestMatchers(HttpMethod.POST).hasRole("NORMAL")
//                                        .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                      requests  .anyRequest().permitAll()
                )
//                if u are using browser then use formlogin
                .formLogin(Customizer.withDefaults())
//                if u are using  postman then use httpbasic
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
