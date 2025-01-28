package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.find;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.TransactionNotFoundException;

public class FindCardByIdUseCaseImpl implements FindCardByIdUseCase {

    private final CardPort cardPort;

    public FindCardByIdUseCaseImpl(CardPort cardPort) {
        this.cardPort = cardPort;
    }

    @Override
    public Card execute(Long id) {
        return cardPort.getCardById(id).orElseThrow(() -> new TransactionNotFoundException("Card not found"));
    }
}
