package com.paymenttransaction.payment_transaction_manager.currency.domain.useCases;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.UpdateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.out.CurrencyPort;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

public class UpdateCurrencyUseCaseImpl implements UpdateCurrencyUseCase {
    private final CurrencyPort currencyPort;

    public UpdateCurrencyUseCaseImpl(CurrencyPort currencyPort) {
        this.currencyPort = currencyPort;
    }

    @Override
    public Currency execute(Currency currency, Long id) {
        return currencyPort.updateCurrency(currency, id).get();
    }
}
