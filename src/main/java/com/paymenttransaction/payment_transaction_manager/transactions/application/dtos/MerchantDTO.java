package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents the data of a merchant")
public class MerchantDTO {
    @Schema(description = "Id of the merchant", example = "1")
    private Long merchantId;
    @Schema(description = "Name of the merchant", example = "Merchant")
    private String name;
}
