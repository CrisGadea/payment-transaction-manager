package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;

import java.util.List;

public interface FindCardsUseCase {
    List<Card> findCardsUseCase(Long userId);
}
