package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.entities.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionEntityMapper {

    TransactionEntityMapper INSTANCE = Mappers.getMapper(TransactionEntityMapper.class);

    Transaction toModel(TransactionEntity entity);

    TransactionEntity toEntity(Transaction model);
}
