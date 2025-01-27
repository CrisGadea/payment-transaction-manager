package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    Transaction toModel(TransactionRequestDTO dto);

    TransactionResponseDTO toResponseDTO(Transaction model);
}
