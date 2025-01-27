package com.paymenttransaction.payment_transaction_manager.users.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.users.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
