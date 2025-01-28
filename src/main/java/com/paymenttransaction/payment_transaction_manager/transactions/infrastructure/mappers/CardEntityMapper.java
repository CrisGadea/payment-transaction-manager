package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Card;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CardEntityMapper {
    CardEntityMapper INSTANCE = Mappers.getMapper(CardEntityMapper.class);

    Card toModel(CardEntity entity);

    CardEntity toEntity(Card model);
}
