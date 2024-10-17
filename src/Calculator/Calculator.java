package Calculator;

public class Calculator implements iCalculator {
    private static Calculator instance;

    // Private constructor to prevent instantiation
    private Calculator() {}

    // Public method to provide access to the singleton instance
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    @Override
    public double exchange(Currencies.Currency inCurr, Currencies.Currency outCurr, double sum) {
        if (inCurr.GetRate() == null || outCurr.GetRate() == null) {
            throw new IllegalArgumentException("Currency rates must not be null.");
        }
        return inCurr.GetRate() / outCurr.GetRate() * sum;
    }
}
