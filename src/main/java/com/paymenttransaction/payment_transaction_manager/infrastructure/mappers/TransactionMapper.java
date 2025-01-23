package com.paymenttransaction.payment_transaction_manager.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionRequestDTO;
import com.paymenttransaction.payment_transaction_manager.application.dtos.transaction.TransactionResponseDTO;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    // Mapear de DTO a Modelo
    @Mapping(target = "id", ignore = true) // Ignorar el ID al mapear
    //@Mapping(target = "status") // Establecer un valor por defecto -> , constant = "PENDING"
    @Mapping(target = "createdAt", ignore = true) // Ignorar el campo creado automáticamente
    Transaction toModel(TransactionRequestDTO dto);

    // Mapear de Modelo a DTO de Respuesta
    TransactionResponseDTO toResponseDTO(Transaction model);
}
