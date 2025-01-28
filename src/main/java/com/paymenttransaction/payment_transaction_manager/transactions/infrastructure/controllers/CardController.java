package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card.CardRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card.CardResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.CardService;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.CardMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions/card")
@Tag(name = "Card Transactions", description = "Endpoints for managing card transactions")
public class CardController {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);
    private final CardService cardService;
    private final CardMapper mapper;

    public CardController(@Lazy CardService cardService, CardMapper mapper){
        this.cardService = cardService;
        this.mapper = mapper;
    }


    @Operation(summary = "Create a new card treansaction", description = "This endpoint allows you to register a new card transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card transaction created successfully",
                    content = @Content(schema = @Schema(implementation = TransactionResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<CardResponseDTO> createTransaction(@Valid @RequestBody CardRequestDTO requestDTO) {
        Card createdTransaction = cardService.execute(mapper.toModel(requestDTO));
        log.info("Transaction created with data: {}", requestDTO);
        CardResponseDTO responseDTO = mapper.toResponseDTO(createdTransaction);
        log.info("Transaction Created successfully: {}", responseDTO);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @Operation(summary = "Get a card transaction by id", description = "This endpoint allows you to get a card transaction by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card transaction found",
                    content = @Content(schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Card transaction not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDTO> getTransaction(@PathVariable Long id) {
        Card transaction = cardService.execute(id);
        CardResponseDTO responseDTO = mapper.toResponseDTO(transaction);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get cards transactions by User id", description = "This endpoint allows you to get a card transaction by card number")
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<CardResponseDTO>> getTransactions(@PathVariable Long userId) {
        List<Card> transaction = cardService.findCardsUseCase(userId);;
        return ResponseEntity.ok(transaction.stream().map(mapper::toResponseDTO).collect(Collectors.toList()));
    }


}
