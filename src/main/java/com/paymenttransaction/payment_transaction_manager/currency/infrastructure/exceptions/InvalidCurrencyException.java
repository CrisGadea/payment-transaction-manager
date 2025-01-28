package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.exceptions;

public class InvalidCurrencyException extends RuntimeException{
    InvalidCurrencyException(String message){super(message);}
}
