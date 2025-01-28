package com.paymenttransaction.payment_transaction_manager.currency.application.ports.in;

import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

public interface CreateCurrencyUseCase {
    Currency execute(Currency currency);
}
