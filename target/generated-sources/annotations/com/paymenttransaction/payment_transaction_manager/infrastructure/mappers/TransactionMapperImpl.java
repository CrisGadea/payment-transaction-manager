package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-23T02:11:39-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toModel(TransactionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setUserId( dto.getUserId() );
        transaction.setAmount( dto.getAmount() );
        transaction.setCurrency( dto.getCurrency() );
        transaction.setTransactionType( dto.getTransactionType() );

        return transaction;
    }

    @Override
    public TransactionResponseDTO toResponseDTO(Transaction model) {
        if ( model == null ) {
            return null;
        }

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();

        transactionResponseDTO.setStatus( model.getStatus() );
        transactionResponseDTO.setAmount( model.getAmount() );
        transactionResponseDTO.setCurrency( model.getCurrency() );
        transactionResponseDTO.setTransactionType( model.getTransactionType() );
        transactionResponseDTO.setCreatedAt( model.getCreatedAt() );

        return transactionResponseDTO;
    }
}
