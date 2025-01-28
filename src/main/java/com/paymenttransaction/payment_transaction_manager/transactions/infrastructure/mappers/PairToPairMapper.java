package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p.PairToPairRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.p2p.PairToPairResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.PairToPair;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PairToPairMapper {
    PairToPairMapper INSTANCE = Mappers.getMapper(PairToPairMapper.class);

    PairToPair toModel(PairToPairRequestDTO dto);

    PairToPairResponseDTO toResponseDTO(PairToPair model);
}
