package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Represents the data of a bank")
public class BankDTO {
    @Schema(description = "Code of the bank", example = "1234")
    private String bankCode;
    @Schema(description = "Name of the bank", example = "Bank of America")
    private String name;
}
