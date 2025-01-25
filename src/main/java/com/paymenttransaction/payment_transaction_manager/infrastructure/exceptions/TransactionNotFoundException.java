package com.paymenttransaction.payment_transaction_manager.infrastructure.exceptions;


public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
