package com.paymenttransaction.payment_transaction_manager.currency.domain.useCases;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.FindCurrencyByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.out.CurrencyPort;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;

public class FindCurrencyByIdUseCaseImpl implements FindCurrencyByIdUseCase {
    private final CurrencyPort currencyPort;

    public FindCurrencyByIdUseCaseImpl(CurrencyPort currencyPort) {
        this.currencyPort = currencyPort;
    }

    @Override
    public Currency execute(Long id) {
        return currencyPort.findCurrencyById(id).get();
    }
}
