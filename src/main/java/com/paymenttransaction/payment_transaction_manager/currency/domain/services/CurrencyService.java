package com.paymenttransaction.payment_transaction_manager.currency.domain.services;

import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.CreateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.FindCurrencyByIdUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.application.ports.in.UpdateCurrencyUseCase;
import com.paymenttransaction.payment_transaction_manager.currency.domain.models.Currency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CurrencyService implements CreateCurrencyUseCase, FindCurrencyByIdUseCase, UpdateCurrencyUseCase {

    CreateCurrencyUseCase createCurrencyUseCase;

    FindCurrencyByIdUseCase findCurrencyByIdUseCase;

    UpdateCurrencyUseCase updateCurrencyUseCase;

    public CurrencyService(@Qualifier("createCurrencyUseCaseImpl") CreateCurrencyUseCase createCurrencyUseCase, @Qualifier("findCurrencyByIdUseCaseImpl") FindCurrencyByIdUseCase findCurrencyByIdUseCase,
                           @Qualifier("updateCurrencyUseCaseImpl") UpdateCurrencyUseCase updateCurrencyUseCase) {
        this.createCurrencyUseCase = createCurrencyUseCase;
        this.findCurrencyByIdUseCase = findCurrencyByIdUseCase;
        this.updateCurrencyUseCase = updateCurrencyUseCase;
    }

    @Override
    public Currency execute(Currency currency) {
        return createCurrencyUseCase.execute(currency);
    }

    @Override
    public Currency execute(Long id) {
        return findCurrencyByIdUseCase.execute(id);
    }

    @Override
    public Currency execute(Currency currency, Long id) {
        return updateCurrencyUseCase.execute(currency, id);
    }





}
