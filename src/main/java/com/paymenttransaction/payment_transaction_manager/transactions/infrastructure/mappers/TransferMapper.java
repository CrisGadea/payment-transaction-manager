package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer.TransferRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.transfer.TransferResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    Transfer toModel(TransferRequestDTO dto);

    TransferResponseDTO toResponseDTO(Transfer model);
}
