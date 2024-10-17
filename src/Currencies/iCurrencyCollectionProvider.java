package Currencies;

import java.util.List;
import java.util.Map;

public interface iCurrencyCollectionProvider {
    public CurrencyCollection parse(String data);
}
