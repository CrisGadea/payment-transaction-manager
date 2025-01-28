package com.paymenttransaction.payment_transaction_manager.transactions.domain.models;

public class PairToPair extends Transaction{
    private String bankCode;
    private String recipientAccount;

    public PairToPair(String bankCode, String recipientAccount) {
        this.bankCode = bankCode;
        this.recipientAccount = recipientAccount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }
}
