package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions;

public class IdempotencyKeyRequiredException extends RuntimeException {
    public IdempotencyKeyRequiredException(String message) {
        super(message);
    }
}
