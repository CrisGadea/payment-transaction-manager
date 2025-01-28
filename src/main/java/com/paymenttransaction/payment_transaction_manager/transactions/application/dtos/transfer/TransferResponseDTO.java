package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferResponseDTO extends TransactionResponseDTO {
    private String bankCode;
    private String recipientAccount;
}
