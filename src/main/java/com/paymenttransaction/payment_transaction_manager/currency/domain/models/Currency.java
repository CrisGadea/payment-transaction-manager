package com.paymenttransaction.payment_transaction_manager.currency.domain.models;

public class Currency {

    private String id;
    private String name;
    private String code;
    private Double exchangeRate;

    public Currency(String id, String name, String code, Double exchangeRate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
