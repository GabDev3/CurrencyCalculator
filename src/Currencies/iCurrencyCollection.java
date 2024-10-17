package Currencies;

import java.time.LocalDate;
import java.util.Map;


public interface iCurrencyCollection {
    Map<String, Currencies.Currency> getCurrencyData();
    public Currency get(String currencyName);
    public LocalDate getDate();
}
