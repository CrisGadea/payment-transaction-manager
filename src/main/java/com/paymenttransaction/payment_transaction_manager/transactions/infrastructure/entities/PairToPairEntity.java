package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities;

import com.paymenttransaction.payment_transaction_manager.users.infrastructure.entities.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "P2PTransaction")
public class PairToPairEntity extends TransactionEntity {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", nullable = false)
    private UserEntity sender; // Relación ManyToOne con UserEntity (remitente)

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", nullable = false)
    private UserEntity recipient; // Relación ManyToOne con UserEntity (destinatario)

    @Column(name = "note")
    private String note;

    // Getters y Setters
    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(UserEntity recipient) {
        this.recipient = recipient;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
