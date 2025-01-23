package com.paymenttransaction.payment_transaction_manager.domain.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public CustomUserDetailsService() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        this.inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        // Agregar un usuario con contraseña cifrada
        inMemoryUserDetailsManager.createUser(
                User.withUsername("user")
                        .password(encoder.encode("password")) // Contraseña cifrada
                        .roles("USER")
                        .build()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return inMemoryUserDetailsManager.loadUserByUsername(username);
    }
}