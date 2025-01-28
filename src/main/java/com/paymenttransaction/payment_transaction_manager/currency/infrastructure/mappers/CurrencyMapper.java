package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.mappers;

import com.paymenttransaction.payment_transaction_manager.currency.application.dtos.currency.CurrencyRequestDTO;
import com.paymenttransaction.payment_transaction_manager.currency.application.dtos.currency.CurrencyResponseDTO;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    @Mapping(target = "id", ignore = true)
    Currency toModel(CurrencyRequestDTO dto);

    CurrencyResponseDTO toResponseDTO(Currency model);
}
