package com.paymenttransaction.payment_transaction_manager.domain.services;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private CreateTransactionUseCase createTransactionUseCase;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void execute_ShouldCreateTransaction() {
        // Arrange
        Transaction mockTransaction = new Transaction();
        mockTransaction.setAmount(BigDecimal.valueOf(1000));
        mockTransaction.setCurrency(Currency.USD);
        Mockito.when(createTransactionUseCase.execute(any(Transaction.class))).thenReturn(mockTransaction);

        // Act
        Transaction result = transactionService.execute(mockTransaction);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(BigDecimal.valueOf(1000), result.getAmount());
        Mockito.verify(createTransactionUseCase, times(1)).execute(mockTransaction);
    }
}