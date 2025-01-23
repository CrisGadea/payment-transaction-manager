package com.paymenttransaction.payment_transaction_manager.application.dtos.transaction;

import com.paymenttransaction.payment_transaction_manager.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDTO {
    private String id;
    private TransactionStatus status;
    private BigDecimal amount;
    private Currency currency;
    private TransactionType transactionType;
    private LocalDateTime createdAt;

    public String getTransactionId() {
        return id;
    }

    public void setTransactionId(String transactionId) {
        this.id = transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
