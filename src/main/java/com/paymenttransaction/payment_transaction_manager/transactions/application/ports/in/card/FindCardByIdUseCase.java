package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;

public interface FindCardByIdUseCase {
    Card execute(Long id);
}
