package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.entities.CurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CurrencyEntityMapper {

    CurrencyEntityMapper INSTANCE = Mappers.getMapper(CurrencyEntityMapper.class);

    CurrencyEntity toEntity(Currency model);

    Currency toDomain(CurrencyEntity entity);
}
