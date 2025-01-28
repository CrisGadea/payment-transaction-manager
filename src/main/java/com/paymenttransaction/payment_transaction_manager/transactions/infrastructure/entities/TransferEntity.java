package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_transfer_transaction")
public class TransferEntity extends TransactionEntity{
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;

    @Column(nullable = false, name = "recipient_account")
    private String recipientAccount;

    // Getters y Setters
    public BankEntity getBank() {
        return bank;
    }

    public void setBank(BankEntity bank) {
        this.bank = bank;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }
}
