package com.paymenttransaction.payment_transaction_manager.transactions.domain.services;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.CreateCardUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.card.FindCardsUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardService implements CreateCardUseCase, FindCardByIdUseCase, FindCardsUseCase {
    private static final Logger log = LoggerFactory.getLogger(CardService.class);

    private final CreateCardUseCase createCardUseCase;
    private final FindCardByIdUseCase findCardByIdUseCase;
    private final FindCardsUseCase findCardsUseCase;

    public CardService(@Qualifier("createCardUseCaseImpl") CreateCardUseCase createCardUseCase, @Qualifier("findCardByIdUseCaseImpl") FindCardByIdUseCase findCardByIdUseCase, @Qualifier("findCardsUseCaseImpl") FindCardsUseCase findCardsUseCase){
        this.createCardUseCase = createCardUseCase;
        this.findCardByIdUseCase = findCardByIdUseCase;
        this.findCardsUseCase = findCardsUseCase;
    }

    @Override
    public Card execute(Card card) {
        log.info("Creating card: {}", card);
        return createCardUseCase.execute(card);
    }

    @Override
    public Card execute(Long id) {
        log.info("Finding card by id: {}", id);
        return findCardByIdUseCase.execute(id);
    }

    @Override
    public List<Card> findCardsUseCase(Long userId) {
        log.info("Finding all cards");
        return findCardsUseCase.findCardsUseCase(userId);
    }


}
