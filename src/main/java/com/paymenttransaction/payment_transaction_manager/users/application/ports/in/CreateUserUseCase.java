package com.paymenttransaction.payment_transaction_manager.users.application.ports.in;

import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;

public interface CreateUserUseCase {
    User execute(User user);
}
