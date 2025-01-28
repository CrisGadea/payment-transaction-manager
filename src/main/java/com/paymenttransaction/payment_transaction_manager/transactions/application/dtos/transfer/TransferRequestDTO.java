package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransferRequestDTO extends TransactionRequestDTO {
    private String bankCode;
    private String recipientAccount;
}
