package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer.TransferResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransferService;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransferMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions/transfers")
@Tag(name = "Bank Transfers", description = "Endpoints for managing bank transfers")
public class TransferController {
    private static final Logger log = LoggerFactory.getLogger(TransferController.class);
    private final TransferService transferService;
    private final TransferMapper transferMapper;

    public TransferController(TransferService transferService, TransferMapper transferMapper) {
        this.transferService = transferService;
        this.transferMapper = transferMapper;
    }

    @Operation(summary = "Create a new bank transfer", description = "This endpoint allows you to register a new bank transfer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank transfer created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Transfer> createTransaction(Transfer transfer) {
        Transfer createdTransaction = transferService.execute(transfer);
        log.info("Transaction created with data: {}", transfer);
        log.info("Transaction Created successfully: {}", createdTransaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }

    @Operation(summary = "Get a bank transfer by id", description = "This endpoint allows you to get a bank transfer by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank transfer found"),
            @ApiResponse(responseCode = "404", description = "Bank transfer not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TransferResponseDTO> getTransactionById(@PathVariable  Long id) {
        Transfer transaction = transferService.findTransferByIdUseCase(id);
        log.info("Transaction found with id: {}", id);
        log.info("Transaction found successfully: {}", transaction);
        return ResponseEntity.status(200).body(transferMapper.toResponseDTO(transaction));
    }

    @Operation(summary = "Get all bank transfers", description = "This endpoint allows you to get all bank transfers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank transfers found"),
            @ApiResponse(responseCode = "404", description = "Bank transfers not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<List<TransferResponseDTO>> getAllTransactions(@PathVariable Long userId) {
        List<Transfer> transactions = transferService.execute(userId);
        log.info("Transactions found successfully: {}", transactions);
        return ResponseEntity.status(200).body(transactions.stream().map(transferMapper::toResponseDTO).collect(Collectors.toList()));
    }
}
