package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransactionService;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
@Tag(name = "Transactions", description = "Endpoints for managing transactions")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;

    private final TransactionMapper mapper;

    public TransactionController(TransactionService transactionService, TransactionMapper mapper){
        this.transactionService = transactionService;
        this.mapper = mapper;
    }

    @Operation(summary = "Create a new transaction", description = "This endpoint allows you to register a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction created successfully",
                    content = @Content(schema = @Schema(implementation = TransactionResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(
            @Valid @RequestBody TransactionRequestDTO requestDTO) {
        log.info("Transaction created with data: {}", requestDTO);

        Transaction createdTransaction = transactionService.execute(mapper.toModel(requestDTO));
        TransactionResponseDTO responseDTO = mapper.toResponseDTO(createdTransaction);

        log.info("Transaction Created successfully: {}", responseDTO);
        return ResponseEntity.status(201).body(responseDTO);
    }
}
