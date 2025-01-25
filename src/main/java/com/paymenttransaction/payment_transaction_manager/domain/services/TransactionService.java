package com.paymenttransaction.payment_transaction_manager.domain.services;

import com.paymenttransaction.payment_transaction_manager.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.exceptions.InvalidTransactionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TransactionService implements CreateTransactionUseCase {

    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private final CreateTransactionUseCase createTransactionUseCase;

    public TransactionService(CreateTransactionUseCase createTransactionUseCase){
        this.createTransactionUseCase = createTransactionUseCase;
    }

    @Override
    public Transaction execute(Transaction transaction) {
        validateTransaction(transaction);
        return createTransactionUseCase.execute(transaction);
    }

    private void validateTransaction(Transaction transaction){
        log.info("Validate transaction: {}", transaction);

        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException("The transaction amount must be greater than 0");
        }

        if (transaction.getCurrency() == null) {
            throw new InvalidTransactionException("Transaction currency is required");
        }

    }
}
