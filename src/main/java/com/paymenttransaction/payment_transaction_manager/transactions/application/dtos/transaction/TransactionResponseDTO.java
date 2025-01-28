package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponseDTO {
    private Long transactionId;
    private TransactionStatus status;
    private BigDecimal amount;
    private Currency currency;
    private TransactionType transactionType;
    private LocalDateTime createdAt;

}
