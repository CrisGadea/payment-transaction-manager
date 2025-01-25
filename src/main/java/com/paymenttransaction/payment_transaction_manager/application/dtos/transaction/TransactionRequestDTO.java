package com.paymenttransaction.payment_transaction_manager.application.dtos.transaction;


import com.paymenttransaction.payment_transaction_manager.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.domain.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Representa los datos necesarios para crear una transacción")
public class TransactionRequestDTO {
    private String userId;
    @Schema(description = "Monto de la transacción", example = "100.50")
    private BigDecimal amount;
    @Schema(description = "Moneda de la transacción", example = "USD")
    private Currency currency;
    @Schema(description = "Tipo de transacción", example = "P2P")
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
