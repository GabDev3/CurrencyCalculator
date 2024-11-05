package master;

public enum MainMenu {
    PRINT_CURRENCIES("1. Print currencies"),
    LOAD_CURRENCIES("2. Load currencies from NBP"),
    EXCHANGE_CURRENCIES_BY_CODE("3. Exchange currencies by code"),
    EXCHANGE_CURRENCIES_BY_NAME("4. Exchange currencies by name"),
    EXIT("5. Exit");


    private final String option;

    MainMenu(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
