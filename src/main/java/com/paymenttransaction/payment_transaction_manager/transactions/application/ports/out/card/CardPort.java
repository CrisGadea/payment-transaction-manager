package com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;

import java.util.List;
import java.util.Optional;

public interface CardPort {
    Card createCard(Card card);
    Optional<Card> getCardById(Long id);
    Optional<List<Card>> getCards(Long userId);
}
