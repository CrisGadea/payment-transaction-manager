package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final TransactionPort transactionPort;
    private final CompensationProducer compensationProducer;

    public CreateTransactionUseCaseImpl(
            TransactionPort transactionPort,
            CompensationProducer compensationProducer
    ) {
        this.transactionPort = transactionPort;
        this.compensationProducer = compensationProducer;
    }

    @Override
    public Transaction execute(Transaction transaction) {
        try {
            // Generar el ID ANTES de persistir
            transaction.setIdempotencyKey(UUID.randomUUID().toString());

            transaction.setStatus(TransactionStatus.PENDING);
            transaction.setCreatedAt(LocalDateTime.now());

            Transaction savedTransaction = transactionPort.createTransaction(transaction);

            // Aquí iría lógica adicional (ej: notificar otros servicios)

            return savedTransaction;

        } catch (Exception ex) {
            // Enviar evento de compensación con el ID generado
            compensationProducer.sendCompensationEvent(
                    new CompensationEvent(transaction.getIdempotencyKey(), TransactionStatus.REFUNDED)
            );
            throw ex;
        }
    }
}