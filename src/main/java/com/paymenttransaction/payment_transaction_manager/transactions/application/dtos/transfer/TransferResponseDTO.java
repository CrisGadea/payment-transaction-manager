package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Represents the data of a created transfer")
public class TransferResponseDTO extends TransactionResponseDTO {
    @Schema(description = "Bank code", example = "1234")
    private String bankCode;
    @Schema(description = "Recipient account", example = "123456")
    private String recipientAccount;
}
