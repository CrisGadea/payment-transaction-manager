package com.paymenttransaction.payment_transaction_manager.infrastructure.controllers;

import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.application.ports.in.CreateTransactionUseCase;
import com.paymenttransaction.payment_transaction_manager.application.useCases.CreateTransactionUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.domain.services.TransactionService;
import com.paymenttransaction.payment_transaction_manager.infrastructure.mappers.TransactionMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    private final TransactionMapper mapper = TransactionMapper.INSTANCE;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {

        Transaction createdTransaction = transactionService.execute(mapper.toModel(requestDTO));

        return ResponseEntity.ok(mapper.toResponseDTO(createdTransaction));
    }
}
