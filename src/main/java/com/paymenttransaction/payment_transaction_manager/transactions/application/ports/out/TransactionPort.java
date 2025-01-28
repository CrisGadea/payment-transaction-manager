package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;

import java.util.Optional;

public interface TransactionPort {
    Transaction createTransaction(Transaction transaction);
    Optional<Transaction> getTransactionById(Long id);
    TransactionStatus getTransactionStatusById(Long id);
}
