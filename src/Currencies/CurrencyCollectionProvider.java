package Currencies;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CurrencyCollectionProvider implements iCurrencyCollectionProvider {
    @Override
    public CurrencyCollection parse(String data) {
        Map<String, Currency> currencyMap = new HashMap<>();

        JSONArray jsonArray = new JSONArray(data);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONArray ratesArray = jsonObject.getJSONArray("rates");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate effectiveDate = LocalDate.parse(jsonObject.getString("effectiveDate"), formatter);

        for (int i = 0; i < ratesArray.length(); i++) {
            JSONObject rateObject = ratesArray.getJSONObject(i);
            String currencyName = rateObject.getString("currency");
            String currencyCode = rateObject.getString("code");
            double midRate = rateObject.getDouble("mid");

            Currency currency = new Currency(currencyName, midRate, currencyCode);
            currencyMap.put(currencyName, currency);
        }

        Currency zlotyPolski = new Currency("Złoty Polski", 1.0, "PLN");
        currencyMap.put("Złoty Polski", zlotyPolski);

        return new CurrencyCollection(currencyMap, effectiveDate);
    }
}
