package com.paymenttransaction.payment_transaction_manager.currency.application.ports.in;

import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

public interface UpdateCurrencyUseCase {
    Currency execute(Currency currency, Long id);
}
