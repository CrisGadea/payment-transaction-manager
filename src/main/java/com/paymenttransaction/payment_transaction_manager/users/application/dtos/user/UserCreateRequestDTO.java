package com.paymenttransaction.payment_transaction_manager.users.application.dtos.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents the data necessary to create a user")
public class UserCreateRequestDTO {

    @Schema(description = "Username of the user", example = "JohnDoe")
    private String username;

    @Schema(description = "Password of the user", example = "12345678") // It should be an encoded password
    private String password;

    @Schema(description = "Email of the user", example = "john.doe@mail.com")
    private String email;



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
}
