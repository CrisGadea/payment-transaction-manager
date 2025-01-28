package com.paymenttransaction.payment_transaction_manager.currency.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.out.CurrencyPort;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.entities.CurrencyEntity;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.mappers.CurrencyEntityMapper;
import com.paymenttransaction.payment_transaction_manager.currency.infrastructure.repositories.CurrencyRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CurrencyAdapter implements CurrencyPort {
    private final CurrencyRepository currencyRepository;
    private final CurrencyEntityMapper currencyMapper;

    public CurrencyAdapter(CurrencyRepository currencyRepository, CurrencyEntityMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public Currency createCurrency(Currency currency) {
        CurrencyEntity currencyEntity = currencyMapper.toEntity(currency);
        CurrencyEntity savedCurrencyEntity = currencyRepository.save(currencyEntity);
        return currencyMapper.toDomain(savedCurrencyEntity);
    }

    @Override
    public Optional<Currency> updateCurrency(Currency currency, Long id) {
        CurrencyEntity currencyEntity = currencyMapper.toEntity(currency);
        CurrencyEntity savedCurrencyEntity = currencyRepository.save(currencyEntity);
        return Optional.of(currencyMapper.toDomain(savedCurrencyEntity));
    }

    @Override
    public Optional<Currency> findCurrencyById(Long id) {
        return currencyRepository.findById(id).map(currencyMapper::toDomain);
    }
}
