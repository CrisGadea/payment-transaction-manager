package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.card.CardPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.CardEntity;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.CardEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.CardRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Cacheable(value = "cards", key = "#userId")
    public Optional<List<Card>> getCards(Long userId) {
        return Optional.of(cardRepository.findAll().stream().map(cardMapper::toModel).toList());
    }

    @Override
    @Cacheable(value = "card", key = "#id")
    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id).map(cardMapper::toModel);
    }

    @Override
    @Transactional
    public Card createCard(Card card) {
        return cardMapper.toModel(cardRepository.save(cardMapper.toEntity(card)));
    }

    @Override
    public TransactionStatus getTransactionStatusById(Long id) {
        return cardRepository.findById(id).map(CardEntity::getStatus).orElse(null);
    }

}
