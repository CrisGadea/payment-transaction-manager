package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;

public interface CreateTransactionUseCase {
    Transaction execute(Transaction transaction);
}
