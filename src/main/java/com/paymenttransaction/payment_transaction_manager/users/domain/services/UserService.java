package com.paymenttransaction.payment_transaction_manager.users.domain.services;

import com.paymenttransaction.payment_transaction_manager.users.application.ports.in.CreateUserUseCase;
import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.exceptions.UserCredentialsRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements CreateUserUseCase {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final CreateUserUseCase createUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public User execute(User user){
        return createUserUseCase.execute(user);
    }

    private void validateData(User user){
        log.info("Validate User {}", user);

        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null){
            throw new UserCredentialsRequiredException("Username, Passwors and Email are mandatory information.");
        }
    }
}
