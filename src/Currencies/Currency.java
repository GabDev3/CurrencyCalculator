package Currencies;

public class Currency
{
    private String currencyName;
    private Double currencyRate;
    private String currencyId;

    public Currency(String currencyName, Double currencyRate, String currencyId) {
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
        this.currencyId = currencyId;
    }


    private void SetName(String name) {
        this.currencyName = name;
    }

    public String GetName() {
        return this.currencyName;
    }

    public String GetId() {
        return this.currencyId;
    }

    public Double GetRate() {
        return this.currencyRate;
    }
}
