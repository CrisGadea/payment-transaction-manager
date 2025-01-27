package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransactionEntity;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<Transaction> findByIdempotencyKey(String idempotencyKey);
}
