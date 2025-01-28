package com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.create;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.CreateCardUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;

public class CreateCardUseCaseImpl implements CreateCardUseCase {
    private final CardPort cardPort;
    private final CompensationProducer compensationProducer;

    public CreateCardUseCaseImpl(
            CardPort cardPort,
            CompensationProducer compensationProducer
    ) {
        this.cardPort = cardPort;
        this.compensationProducer = compensationProducer;
    }

    @Override
    public Card execute(Card card) {
        try {
            return cardPort.createCard(card);
        } catch (Exception ex) {
            compensationProducer.sendCompensationEvent(
                    new CompensationEvent(card.getIdempotencyKey(), TransactionStatus.REFUNDED)
            );
            throw ex;
        }
    }
}
