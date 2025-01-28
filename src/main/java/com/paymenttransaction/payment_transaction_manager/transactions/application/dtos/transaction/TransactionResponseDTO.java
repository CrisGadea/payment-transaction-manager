package com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.Currency;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "Represents the data of a created transaction")
public class TransactionResponseDTO {
    @Schema(description = "Id of the transaction", example = "1")
    private Long transactionId;
    @Schema(description = "Status of the transaction", example = "PENDING")
    private TransactionStatus status;
    @Schema(description = "Amount of the transaction", example = "100.00")
    private BigDecimal amount;
    @Schema(description = "Currency of the transaction", example = "USD")
    private Currency currency;
    @Schema(description = "Type of transaction", example = "P2P")
    private TransactionType transactionType;
    @Schema(description = "Date of creation", example = "2021-01-01T00:00:00")
    private LocalDateTime createdAt;

}
