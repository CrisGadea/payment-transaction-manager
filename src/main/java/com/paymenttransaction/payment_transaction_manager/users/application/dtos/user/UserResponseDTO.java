package com.paymenttransaction.payment_transaction_manager.users.application.dtos.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDate createdAt;

}
