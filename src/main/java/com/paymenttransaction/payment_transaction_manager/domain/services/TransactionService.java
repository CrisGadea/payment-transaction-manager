package com.paymenttransaction.payment_transaction_manager.domain.services;

import com.paymenttransaction.payment_transaction_manager.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;

public class TransactionService implements CreateTransactionUseCase {

    private final CreateTransactionUseCase createTransactionUseCase;

    public TransactionService(CreateTransactionUseCase createTransactionUseCase){
        this.createTransactionUseCase = createTransactionUseCase;
    }

    @Override
    public Transaction execute(Transaction transaction) {
        // Aquí puedes aplicar validaciones o lógica adicional antes de delegar al adaptador
        return createTransactionUseCase.execute(transaction);
    }
}
