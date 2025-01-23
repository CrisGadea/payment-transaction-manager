package com.paymenttransaction.payment_transaction_manager.application.ports.out;

import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;

import java.util.Optional;

public interface TransactionPort {
    Transaction createTransaction(Transaction transaction);
    Optional<Transaction> getTransactionById(Long id);
}
