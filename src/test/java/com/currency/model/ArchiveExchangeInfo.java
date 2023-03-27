package com.currency.model;

import java.util.List;

public class ArchiveExchangeInfo {

    private String date;
    private String bank;
    private Integer baseCurrency;
    private String baseCurrencyLit;
    private List<ArchiveCashExchange> exchangeRate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Integer baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public List<ArchiveCashExchange> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(List<ArchiveCashExchange> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "ArchiveExchangeInfo{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
