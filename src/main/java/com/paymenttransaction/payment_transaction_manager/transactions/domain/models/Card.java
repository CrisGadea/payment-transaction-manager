package com.paymenttransaction.payment_transaction_manager.transactions.domain.models;

public class Card extends Transaction{
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;

    public Card(String cardNumber, String cardHolder, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }
}
