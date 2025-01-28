package com.paymenttransaction.payment_transaction_manager.currency.domain.useCases;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.CreateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.out.CurrencyPort;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

public class CreateCurrencyUseCaseImpl implements CreateCurrencyUseCase {

    private final CurrencyPort currencyPort;

    public CreateCurrencyUseCaseImpl(CurrencyPort currencyPort) {
        this.currencyPort = currencyPort;
    }

    @Override
    public Currency execute(Currency currency) {
        return currencyPort.createCurrency(currency);
    }

}
