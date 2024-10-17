import Calculator.Calculator;
import Currencies.CurrencyCollection;
import Currencies.CurrencyCollectionProvider;
import DataProvidingAndDecoder.Decoder;
import DataProvidingAndDecoder.RestDataProvider;
import java.util.Map;


public class Main
{
    public static void main(String[] args) {
        System.out.println("Start\n");

        RestDataProvider restDataProvider = new RestDataProvider();
        try {
            byte[] data = restDataProvider.fetchData("https://api.nbp.pl/api/exchangerates/tables/a/");
            System.out.println("Data fetched successfully");

            Decoder decoder = new Decoder();
            String decodedData = decoder.decode(data);
            System.out.println("Decoded data: " + decodedData + "\n");

            CurrencyCollectionProvider currencyCollectionProvider = new CurrencyCollectionProvider();

            CurrencyCollection collection1 = currencyCollectionProvider.parse(decodedData);

            System.out.println("Collection1: " + collection1.getCurrencyData() + "\n");

            for (Map.Entry<String, Currencies.Currency> entry : collection1.getCurrencyData().entrySet()) {
                System.out.println(entry.getKey() + "- imie: " + entry.getValue().GetName() + ", id: " +
                        entry.getValue().GetId() + ", rate: " + String.format("%.6f", entry.getValue().GetRate()));
            }
            System.out.println("\n");

            Calculator calc = Calculator.getInstance();
            System.out.println("\n100.1 USD to euro = " + calc.exchange(collection1.get("dolar amerykański"), collection1.get("euro"), 100.1));
            System.out.println("data aktualizacji tabeli: " + collection1.getDate());
        }
        catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }



        System.out.println("End");
    }
}
