package com.paymenttransaction.payment_transaction_manager.users.infrastructure.exceptions;

public class UserCredentialsRequiredException extends RuntimeException {
    public UserCredentialsRequiredException(String message){super(message);}
}
