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

    public void addCurrency(Currency currency) {
        currencies.add(currency);
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
