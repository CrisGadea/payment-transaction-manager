package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.CardEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.CardRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CardAdapter implements CardPort {
    private final CardRepository cardRepository;
    private final CardEntityMapper cardMapper;

    public CardAdapter(CardRepository cardRepository, CardEntityMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public Optional<List<Card>> getCards(Long userId) {
        return Optional.of(cardRepository.findAll().stream().map(cardMapper::toModel).toList());
    }

    @Override
    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id).map(cardMapper::toModel);
    }

    @Override
    public Card createCard(Card card) {
        return cardMapper.toModel(cardRepository.save(cardMapper.toEntity(card)));
    }

}
