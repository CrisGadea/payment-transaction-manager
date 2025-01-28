package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardResponseDTO extends TransactionResponseDTO {
    private Long cardId;
    private String merchantName;
    private String mccCode;
}
