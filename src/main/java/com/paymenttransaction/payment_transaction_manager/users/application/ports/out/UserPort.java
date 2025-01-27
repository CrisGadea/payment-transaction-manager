package com.paymenttransaction.payment_transaction_manager.users.application.ports.out;


import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;

import java.util.Optional;

public interface UserPort {
    User createUser(User transaction);
    Optional<User> getUserById(Long id);
}
