package com.paymenttransaction.payment_transaction_manager.application.dtos.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request payload for user login")
public class AuthRequest {
    @Schema(description = "Username of the user", example = "john_doe")
    private String username;
    @Schema(description = "Password of the user", example = "securepassword123")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
