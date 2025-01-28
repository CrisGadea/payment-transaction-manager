package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p.PairToPairResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.PairToPairService;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.PairToPairMapper;
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
@RequestMapping("/api/v1/transactions/p2p")
@Tag(name = "Pair To Pair Transactions", description = "Endpoints for managing pair to pair transactions")
public class PairToPairController {

    private static final Logger log = LoggerFactory.getLogger(PairToPairController.class);
    PairToPairService pairToPairService;
    PairToPairMapper pairToPairMapper;

    public PairToPairController(PairToPairService pairToPairService, PairToPairMapper pairToPairMapper) {
        this.pairToPairService = pairToPairService;
        this.pairToPairMapper = pairToPairMapper;
    }

    @Operation(summary = "Create a new pair to pair transaction", description = "This endpoint allows you to register a new pair to pair transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pair to pair transaction created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<PairToPair> createTransaction(PairToPair pairToPair) {
        PairToPair createdTransaction = pairToPairService.execute(pairToPair);
        log.info("Transaction created with data: {}", pairToPair);
        log.info("Transaction Created successfully: {}", createdTransaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }

    @Operation(summary = "Get a pair to pair transaction by id", description = "This endpoint allows you to get a pair to pair transaction by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pair to pair transaction found"),
            @ApiResponse(responseCode = "404", description = "Pair to pair transaction not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PairToPairResponseDTO> getTransactionById(@PathVariable  Long id) {
        PairToPair transaction = pairToPairService.findPairToPairById(id);
        log.info("Transaction found with id: {}", id);
        log.info("Transaction found successfully: {}", transaction);
        return ResponseEntity.status(200).body(pairToPairMapper.toResponseDTO(transaction));
    }

    @Operation(summary = "Get all pair to pair transactions", description = "This endpoint allows you to get all pair to pair transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pair to pair transactions found"),
            @ApiResponse(responseCode = "404", description = "Pair to pair transactions not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<PairToPairResponseDTO>> getAllTransactions(@PathVariable Long userId) {
        List<PairToPair> transactions = pairToPairService.findPairToPairsByUserId(userId);
        log.info("Transactions found successfully: {}", transactions);
        return ResponseEntity.status(200).body(transactions.stream().map(pairToPairMapper::toResponseDTO).collect(Collectors.toList()));
    }



}
