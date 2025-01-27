package com.paymenttransaction.payment_transaction_manager.users.application.dtos.user;

import java.time.LocalDate;

public class UserResponseDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDate createdAt;


    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
