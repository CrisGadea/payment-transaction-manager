package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transfer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransferEntityMapper {
    TransferEntityMapper INSTANCE = Mappers.getMapper(TransferEntityMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    TransferEntity toEntity(Transfer transfer);

    Transfer toModel(TransferEntity entity);
}
