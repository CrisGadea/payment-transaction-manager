package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardRequestDTO extends TransactionRequestDTO {
    private Long cardId;
    private Long merchantId;
    private String mccCode;
}
