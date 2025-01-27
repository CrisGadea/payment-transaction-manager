package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionEntityMapper {

    TransactionEntityMapper INSTANCE = Mappers.getMapper(TransactionEntityMapper.class);

    Transaction toModel(TransactionEntity entity);

    TransactionEntity toEntity(Transaction model);
}
