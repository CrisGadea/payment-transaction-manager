package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.currency.application.dtos.currency.CurrencyRequestDTO;
import com.paymenttransaction.payment_transaction_manager.currency.application.dtos.currency.CurrencyResponseDTO;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;
import com.paymenttransaction.payment_transaction_manager.currency.domain.services.CurrencyService;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.mappers.CurrencyMapper;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currency")
@Tag(name = "Currency", description = "Endpoints for managing currency")
public class CurrencyController {
    private static final Logger log = LoggerFactory.getLogger(CurrencyController.class);
    private final CurrencyService currencyService;
    private final CurrencyMapper mapper;

    public CurrencyController(@Lazy CurrencyService currencyService, CurrencyMapper mapper){
        this.currencyService = currencyService;
        this.mapper = mapper;
    }

    @Operation(summary = "Create a new currency", description = "This endpoint allows you to create a new currency")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency created successfully",
                    content = @Content(schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Currency> createCurrency(
        @Valid @RequestBody CurrencyRequestDTO requestDTO
    ){
        Currency createdCurrency = currencyService.execute(mapper.toModel(requestDTO));
        log.info("Currency created with data: {}", requestDTO);
        return ResponseEntity.status(201).body(createdCurrency);
    }

    @Operation(summary = "Get currency by id", description = "This endpoint allows you to get a currency by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency retrieved successfully",
                    content = @Content(schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Currency> getCurrencyById(
        @Valid @PathVariable Long id
    ){
        Currency currency = currencyService.execute(id);
        log.info("Currency retrieved with data: {}", currency);
        return ResponseEntity.status(200).body(currency);
    }

    @Operation(summary = "Update currency", description = "This endpoint allows you to update a currency")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency updated successfully",
                    content = @Content(schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    public ResponseEntity<Currency> updateCurrency(
        @Valid @RequestBody CurrencyRequestDTO requestDTO
    ){
        Currency currency = currencyService.execute(mapper.toModel(requestDTO));
        log.info("Currency updated with data: {}", requestDTO);
        return ResponseEntity.status(200).body(currency);
    }



}
