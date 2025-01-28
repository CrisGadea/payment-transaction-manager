package com.paymenttransaction.payment_transaction_manager.transactions.domain.models;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;

import java.io.Serializable;

public class CompensationEvent implements Serializable {
    private String transactionId;
    private TransactionStatus action;

    public CompensationEvent(String transactionId, TransactionStatus action) {
        this.transactionId = transactionId;
        this.action = action;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getAction() {
        return action;
    }

    public void setAction(TransactionStatus action) {
        this.action = action;
    }
}
