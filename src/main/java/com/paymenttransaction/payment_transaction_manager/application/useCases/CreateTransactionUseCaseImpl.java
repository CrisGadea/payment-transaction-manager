package com.paymenttransaction.payment_transaction_manager.application.useCases;

import com.paymenttransaction.payment_transaction_manager.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final TransactionPort transactionPort;

    public CreateTransactionUseCaseImpl(TransactionPort transactionPort) {
        this.transactionPort = transactionPort;
    }

    @Override
    public Transaction execute(Transaction transaction) {
        // Aquí puedes aplicar validaciones o lógica adicional antes de delegar al adaptador
        transaction.setIdempotencyKey(UUID.randomUUID().toString());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setCreatedAt(LocalDateTime.now());
        return transactionPort.createTransaction(transaction);
    }
}
