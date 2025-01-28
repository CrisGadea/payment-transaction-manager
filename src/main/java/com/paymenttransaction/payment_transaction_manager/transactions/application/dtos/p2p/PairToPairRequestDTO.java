package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PairToPairRequestDTO extends TransactionRequestDTO {
    private Long recipientId;
    private String note;
}
