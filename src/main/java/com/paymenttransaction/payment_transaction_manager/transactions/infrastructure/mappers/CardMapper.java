package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card.CardRequestDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.application.dtos.card.CardResponseDTO;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "createdAt", ignore = true)
    Card toModel(CardRequestDTO dto);

    CardResponseDTO toResponseDTO(Card model);
}
