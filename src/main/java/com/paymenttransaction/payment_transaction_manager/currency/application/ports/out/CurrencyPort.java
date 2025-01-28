package com.paymenttransaction.payment_transaction_manager.currency.application.ports.out;

import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

import java.util.Optional;

public interface CurrencyPort {
    Currency createCurrency(Currency currency);

    Optional<Currency> findCurrencyById(Long id);

    Optional<Currency> updateCurrency(Currency currency, Long id);

}
