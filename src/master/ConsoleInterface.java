package master;

import java.util.Scanner;
import Currencies.CurrencyCollection;

public class ConsoleInterface {
    private int Choice;

    public ConsoleInterface()
    {
        this.Choice = 0;
    }

    public void showMainMenu()
    {
        System.out.println("Main menu:");
        for (MainMenu option : MainMenu.values()) {
            System.out.println(option.getOption());
        }
        System.out.println("Enter your choice: ");
    }

    public int GetChoice()
    {
        return this.Choice;
    }

    public void setChoice(String choice)
    {
        try {
            this.Choice = Integer.parseInt(choice);
        }
        catch (Exception e) {
            System.out.println("Non-integer choice input!: " + e.getMessage());
        }
    }

    public void ExchangeCurrenciesByCode(CurrencyCollection collection)
    {
        try {
            Scanner scanner = new Scanner(System.in);

            Requests requests = new Requests();

            System.out.println("Enter the amount to exchange: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the code of the currency to exchange from: ");
            String inId = scanner.nextLine();

            System.out.println("Enter the code of the currency to exchange to: ");
            String outId = scanner.nextLine();

            System.out.println("Wymiana: " + sum + " " + inId + " = " + String.format("%.2f", requests.exchangeCurrencyByCode(collection, inId, outId, sum)) + " " + outId);
        }
        catch (Exception e) {
            System.out.println("Error exchanging currencies: " + e.getMessage());
        }
    }

    public void ExchangeCurrenciesByName(CurrencyCollection collection)
    {
        try {
            Scanner scanner = new Scanner(System.in);

            Requests requests = new Requests();

            System.out.println("Enter the amount to exchange: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the name of the currency to exchange from: ");
            String inName = scanner.nextLine();

            System.out.println("Enter the name of the currency to exchange to: ");
            String outName = scanner.nextLine();

            System.out.println("Wymiana: " + sum + " " + inName + " = " + String.format("%.2f", requests.exchangeCurrencyByName(collection, inName, outName, sum)) + " " + outName);
        }
        catch (Exception e) {
            System.out.println("Error exchanging currencies: " + e.getMessage());
        }
    }


}

