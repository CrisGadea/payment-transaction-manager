package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Represents the data of a created card transfer")
public class CardResponseDTO extends TransactionResponseDTO {
    @Schema(description = "Id of the card", example = "1")
    private Long cardId;
    @Schema(description = "Id of the merchant", example = "1")
    private String merchantName;
    @Schema(description = "MCC code", example = "1234")
    private String mccCode;
}
