package com.paymenttransaction.payment_transaction_manager.application.ports.in;

import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;

public interface CreateTransactionUseCase {
    Transaction execute(Transaction transaction);
}
