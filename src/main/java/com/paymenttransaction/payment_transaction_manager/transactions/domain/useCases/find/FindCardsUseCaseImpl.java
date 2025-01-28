package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardsUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

import java.util.List;

public class FindCardsUseCaseImpl implements FindCardsUseCase {
    private final CardPort cardPort;

    public FindCardsUseCaseImpl(CardPort cardPort) {
        this.cardPort = cardPort;
    }

    @Override
    public List<Card> findCardsUseCase(Long userId) {
        return cardPort.getCards(userId).orElseThrow(() -> new TransactionNotFoundException("Cards not found"));
    }
}
