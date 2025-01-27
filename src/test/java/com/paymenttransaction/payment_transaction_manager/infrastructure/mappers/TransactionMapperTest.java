package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionType;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionMapperTest {

    private final TransactionMapper mapper = TransactionMapper.INSTANCE;

    @Test
    void shouldMapRequestDTOToModel() {
        // Given
        TransactionRequestDTO requestDTO = new TransactionRequestDTO();
        requestDTO.setUserId("12345");
        requestDTO.setAmount(new BigDecimal("100.50"));
        requestDTO.setCurrency(Currency.USD);
        requestDTO.setTransactionType(TransactionType.CARD);

        // When
        Transaction transaction = mapper.toModel(requestDTO);

        // Then
        assertNotNull(transaction);
        assertEquals("12345", transaction.getUserId());
        assertEquals(new BigDecimal("100.50"), transaction.getAmount());
        assertEquals(Currency.USD, transaction.getCurrency());
        assertEquals(TransactionType.CARD, transaction.getTransactionType());
    }

    @Test
    void shouldMapModelToResponseDTO() {
        // Given
        Transaction transaction = new Transaction();
        transaction.setUserId("12345");
        transaction.setAmount(new BigDecimal("100.50"));
        transaction.setCurrency(Currency.USD);
        transaction.setTransactionType(TransactionType.CARD);
        transaction.setStatus(TransactionStatus.COMPLETED);

        // When
        TransactionResponseDTO responseDTO = mapper.toResponseDTO(transaction);

        // Then
        assertNotNull(responseDTO);
        assertEquals(new BigDecimal("100.50"), responseDTO.getAmount());
        assertEquals(Currency.USD, responseDTO.getCurrency());
        assertEquals(TransactionType.CARD, responseDTO.getTransactionType());
        assertEquals(TransactionStatus.COMPLETED, responseDTO.getStatus());
    }
}
