package ru.tbank.service;

import org.springframework.stereotype.Service;
import ru.tbank.model.Currency;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class serviceCurrency {
    private final List<Currency> currencies = new ArrayList();

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency addCurrency(Currency currency) {
        for(Currency currency1 : currencies){
            if(currency1.getId().equals(currency.getId())){
                return currency;
            }
        }
        String id = UUID.randomUUID().toString();
        currency.setId(id);
        currencies.add(currency);
        return currency;
    }

    public Currency getCurrencyById(String id) {
        return currencies.stream()
                .filter(currency -> currency.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Currency updateCurrency(String id, Currency currency) {
        Currency updatedCurrency = this.getCurrencyById(id);
        updatedCurrency.setName(currency.getName());
        updatedCurrency.setBaseCurrency(currency.getBaseCurrency());
        updatedCurrency.setPriceChangeRange(currency.getPriceChangeRange());
        updatedCurrency.setDescription(currency.getDescription());
        return updatedCurrency;
    }

    public void deleteCurrencyById(String id) {
        currencies.removeIf(currency -> currency.getId().equals(id));
    }
}















