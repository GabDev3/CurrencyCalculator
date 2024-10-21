package master;

import Calculator.Calculator;
import Currencies.CurrencyCollection;
import Currencies.CurrencyCollectionProvider;
import DataProvidingAndDecoder.Decoder;
import DataProvidingAndDecoder.RestDataProvider;

import java.util.Map;

public class Requests {

    public CurrencyCollection loadCurrencies() {
        RestDataProvider restDataProvider = new RestDataProvider();
        try {
            byte[] data = restDataProvider.fetchData("https://api.nbp.pl/api/exchangerates/tables/a/");

            Decoder decoder = new Decoder();
            String decodedData = decoder.decode(data);

            CurrencyCollectionProvider currencyCollectionProvider = new CurrencyCollectionProvider();
            return currencyCollectionProvider.parse(decodedData);
        }
        catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
            return null;
        }
    }

    public double exchangeCurrencyByCode(CurrencyCollection ccollection, String inId, String outId, double sum) {
        Calculator calc = Calculator.getInstance();
        try {
            return calc.exchange(ccollection.getCurrencyByCode(inId), ccollection.getCurrencyByCode(outId), sum);
        } catch (Exception e) {
            System.out.println("Error exchanging currency: " + e.getMessage());
            return -1;
        }
    }

    public double exchangeCurrencyByName(CurrencyCollection ccollection, String inName, String outName, double sum) {
        Calculator calc = Calculator.getInstance();
        try {
            return calc.exchange(ccollection.getCurrencyByName(inName), ccollection.getCurrencyByName(outName), sum);
        } catch (Exception e) {
            System.out.println("Error exchanging currency: " + e.getMessage());
            return -1;
        }
    }

    public void printCurrencies(CurrencyCollection ccollection) {
        Map<String, Currencies.Currency> currencies = ccollection.getCurrencyData();
        for (Currencies.Currency currency : currencies.values()) {
            System.out.println(currency.GetName() + " " + currency.GetId() + " " + String.format("%.2f", currency.GetRate()));
        }
    }

}
