package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "card_transaction")
public class CardEntity extends TransactionEntity {
    @Column(nullable = false, name = "card_id")
    private Long cardId; // Cambiado a Long

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "merchant_id", nullable = false)
    private MerchantEntity merchant; // Relación ManyToOne con MerchantEntity

    @Column(name = "mcc_code")
    private String mccCode;

    // Getters y Setters
    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public MerchantEntity getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantEntity merchant) {
        this.merchant = merchant;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }
}
