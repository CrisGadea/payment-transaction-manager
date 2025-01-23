package com.paymenttransaction.payment_transaction_manager.application.dtos.transaction;


import com.paymenttransaction.payment_transaction_manager.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionType;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    private String userId;
    private BigDecimal amount;
    private Currency currency;
    private TransactionType transactionType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
