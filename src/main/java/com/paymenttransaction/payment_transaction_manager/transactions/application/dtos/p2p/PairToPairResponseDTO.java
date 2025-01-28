package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PairToPairResponseDTO extends TransactionResponseDTO {
    private Long senderId;
    private Long recipientId;
    private String note;
}
