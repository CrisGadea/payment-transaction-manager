package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionType;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.entities.TransactionEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TransactionEntityMapperTest {
    private final TransactionEntityMapper mapper = TransactionEntityMapper.INSTANCE;

    @Test
    void shouldMapModelToEntity() {
        // Given
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setUserId("12345");
        transaction.setAmount(new BigDecimal("100.50"));
        transaction.setCurrency(Currency.USD);
        transaction.setTransactionType(TransactionType.CARD);
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setCreatedAt(LocalDateTime.now());

        // When
        TransactionEntity entity = mapper.toEntity(transaction);

        // Then
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("12345", entity.getUserId());
        assertEquals(new BigDecimal("100.50"), entity.getAmount());
        assertEquals(Currency.USD, entity.getCurrency());
        assertEquals(TransactionType.CARD, entity.getTransactionType());
        assertEquals(TransactionStatus.PENDING, entity.getStatus());
    }

    @Test
    void shouldMapEntityToModel() {
        // Given
        TransactionEntity entity = new TransactionEntity();
        entity.setId(1L);
        entity.setUserId("12345");
        entity.setAmount(new BigDecimal("100.50"));
        entity.setCurrency(Currency.USD);
        entity.setTransactionType(TransactionType.CARD);
        entity.setStatus(TransactionStatus.COMPLETED);
        entity.setCreatedAt(LocalDateTime.now());

        // When
        Transaction transaction = mapper.toModel(entity);

        // Then
        assertNotNull(transaction);
        assertEquals(1L, transaction.getId());
        assertEquals("12345", transaction.getUserId());
        assertEquals(new BigDecimal("100.50"), transaction.getAmount());
        assertEquals(Currency.USD, transaction.getCurrency());
        assertEquals(TransactionType.CARD, transaction.getTransactionType());
        assertEquals(TransactionStatus.COMPLETED, transaction.getStatus());
    }
}
