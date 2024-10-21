package Currencies;

import java.time.LocalDate;
import java.util.Map;


public interface iCurrencyCollection {
    Map<String, Currencies.Currency> getCurrencyData();
    public Currency getCurrencyByName(String currencyName);
    public Currency getCurrencyByCode(String currencyId);
    public LocalDate getDate();
}
