package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction;


import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Represents the data necessary to create a transaction")
public class TransactionRequestDTO {
    private String userId;
    @Schema(description = "Amount of the transaction", example = "100.50")
    private BigDecimal amount;
    @Schema(description = "Currency of the transaction", example = "USD")
    private Currency currency;
    @Schema(description = "Type of transaction", example = "P2P")
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
