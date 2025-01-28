package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Represents the data necessary to create a card transfer")
public class CardRequestDTO extends TransactionRequestDTO {
    @Schema(description = "Id of the card", example = "1")
    private Long cardId;
    @Schema(description = "Id of the merchant", example = "1")
    private Long merchantId;
    @Schema(description = "MCC code", example = "1234")
    private String mccCode;
}
