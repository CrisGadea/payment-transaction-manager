package com.paymenttransaction.payment_transaction_manager.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<Transaction> findByIdempotencyKey(String idempotencyKey);
}
