package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.entities.TransactionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-25T17:36:29-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class TransactionEntityMapperImpl implements TransactionEntityMapper {

    @Override
    public Transaction toModel(TransactionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( entity.getId() );
        transaction.setUserId( entity.getUserId() );
        transaction.setAmount( entity.getAmount() );
        transaction.setCurrency( entity.getCurrency() );
        transaction.setTransactionType( entity.getTransactionType() );
        transaction.setStatus( entity.getStatus() );
        transaction.setIdempotencyKey( entity.getIdempotencyKey() );
        transaction.setCreatedAt( entity.getCreatedAt() );

        return transaction;
    }

    @Override
    public TransactionEntity toEntity(Transaction model) {
        if ( model == null ) {
            return null;
        }

        TransactionEntity transactionEntity = new TransactionEntity();

        transactionEntity.setId( model.getId() );
        transactionEntity.setUserId( model.getUserId() );
        transactionEntity.setAmount( model.getAmount() );
        transactionEntity.setCurrency( model.getCurrency() );
        transactionEntity.setTransactionType( model.getTransactionType() );
        transactionEntity.setStatus( model.getStatus() );
        transactionEntity.setIdempotencyKey( model.getIdempotencyKey() );
        transactionEntity.setCreatedAt( model.getCreatedAt() );

        return transactionEntity;
    }
}
