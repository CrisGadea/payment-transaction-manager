package com.paymenttransaction.payment_transaction_manager.currency.application.dtos.currency;

import lombok.Data;

@Data
public class CurrencyRequestDTO {

    private String name;
    private String code;
    private Double exchangeRate;

}
