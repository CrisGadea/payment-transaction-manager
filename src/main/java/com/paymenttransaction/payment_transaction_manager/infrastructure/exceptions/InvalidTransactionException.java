package com.paymenttransaction.payment_transaction_manager.infrastructure.exceptions;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
