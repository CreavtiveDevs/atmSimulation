package AtmSimulation;

public abstract class Transaction {
    private final int accountNumber;
    private final Screen screen;
    private final BankDatabase bankDatabase;

    public Transaction(int UseraccountNumber, Screen atmScreen, BankDatabase database) {
        accountNumber = UseraccountNumber;
        screen = atmScreen;
        bankDatabase = database;
    }

    // Return the account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Return reference to the screen
    public Screen getScreen() {
        return screen;
    }

    // Return reference to the bank database
    public BankDatabase getDatabase() {
        return bankDatabase;
    }

    abstract public void execute();
}
