import master.ConsoleInterface;
import master.Requests;
import Currencies.CurrencyCollection;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) {

        Requests requests = new Requests();
        CurrencyCollection currencyCollection = requests.loadCurrencies();
        if (currencyCollection == null) {
            System.out.println("Error loading currencies");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        ConsoleInterface conUI = new ConsoleInterface();
        while(conUI.GetChoice() != 5) {
            conUI.showMainMenu();
            conUI.setChoice(scanner.nextLine());
            switch(conUI.GetChoice()){
                case 1:
                    requests.printCurrencies(currencyCollection);
                    break;
                case 2:
                    currencyCollection = requests.loadCurrencies();
                    break;
                case 3:
                    conUI.ExchangeCurrenciesByCode(currencyCollection);
                    break;
                case 4:
                    conUI.ExchangeCurrenciesByName(currencyCollection);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
        scanner.close();

    }
}