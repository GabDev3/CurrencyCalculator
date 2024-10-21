package Currencies;

import java.time.LocalDate;
import java.util.Map;

public class CurrencyCollection implements iCurrencyCollection {
    private Map<String, Currencies.Currency> currencyData;
    private LocalDate lastUpdated;

    public CurrencyCollection(Map<String, Currencies.Currency> currencyData, LocalDate date) {
        this.currencyData = currencyData;
        this.lastUpdated = date;
    }

    private void addCurrency(Currencies.Currency currency) {
        this.currencyData.put(currency.GetName(), currency);
    }

    private void removeCurrency(String currencyName) {
        this.currencyData.remove(currencyName);
    }

    @Override
    public LocalDate getDate() {
        return this.lastUpdated;
    }

    @Override
    public Currency getCurrencyByName(String currencyName) {
        return this.currencyData.get(currencyName);
    }

    @Override
    public Currency getCurrencyByCode(String currencyId) {
        try {
            for (Currency currency : currencyData.values()) {
                if (currencyId.equals(currency.GetId())) {
                    return currency;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Currency not found: " + e.getMessage());
            return null;
        }
        return null;
    }


    @Override
    public Map<String, Currencies.Currency> getCurrencyData() {
        return this.currencyData;
    }
}
