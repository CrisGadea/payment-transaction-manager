package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Represents the data necessary to create a pair to pair transfer")
public class PairToPairRequestDTO extends TransactionRequestDTO {
    @Schema(description = "Id of the recipient", example = "1")
    private Long recipientId;
    @Schema(description = "Note", example = "This is a note")
    private String note;
}
