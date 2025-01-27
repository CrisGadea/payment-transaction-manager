package com.paymenttransaction.payment_transaction_manager.domain.useCases;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.CreateTransactionUseCaseImpl;
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
class CreateTransactionUseCaseImplTest {

    @Mock
    private TransactionPort transactionPort;

    @InjectMocks
    private CreateTransactionUseCaseImpl createTransactionUseCase;

    @Test
    void execute_ShouldAssignDefaultValuesAndSaveTransaction() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.valueOf(1000));
        Mockito.when(transactionPort.createTransaction(any(Transaction.class))).thenReturn(transaction);

        // Act
        Transaction result = createTransactionUseCase.execute(transaction);

        // Assert
        Assertions.assertNotNull(result.getIdempotencyKey());
        Assertions.assertEquals(TransactionStatus.PENDING, result.getStatus());
        Mockito.verify(transactionPort, times(1)).createTransaction(transaction);
    }
}
