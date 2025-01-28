package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Represents the data of a created pair to pair transfer")
public class PairToPairResponseDTO extends TransactionResponseDTO {
    @Schema(description = "Id of the sender user", example = "1")
    private Long senderId;
    @Schema(description = "Id of the recipient user", example = "1")
    private Long recipientId;
    @Schema(description = "Note", example = "This is a note")
    private String note;
}
