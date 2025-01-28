package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.PairToPairEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PairToPairEntityMapper {
    PairToPairEntityMapper INSTANCE = Mappers.getMapper(PairToPairEntityMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    PairToPairEntity toEntity(PairToPair pairToPair);

    PairToPair toModel(PairToPairEntity entity);
}
