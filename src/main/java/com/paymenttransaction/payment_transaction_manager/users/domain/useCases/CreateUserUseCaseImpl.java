package com.paymenttransaction.payment_transaction_manager.users.domain.useCases;

import com.paymenttransaction.payment_transaction_manager.users.application.ports.in.CreateUserUseCase;
import com.paymenttransaction.payment_transaction_manager.users.application.ports.out.UserPort;
import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;

import java.time.LocalDate;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserPort userPort;

    public CreateUserUseCaseImpl(UserPort userPort){
        this.userPort = userPort;
    }

    @Override
    public User execute(User user){
        user.setCreatedAt(LocalDate.now());
        return userPort.createUser(user);
    }


}
