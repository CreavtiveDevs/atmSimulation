package AtmSimulation;

public class CheckBalance extends Transaction {

    public CheckBalance(int UserAccountNumber, Screen atmScreen, BankDatabase database) {
        super(UserAccountNumber, atmScreen, database);

    }
    // performs the transaction
    public void execute() {
        // Get reference available balance to the bank database and screen
        BankDatabase database = getDatabase();
        Screen screen = getScreen();

        // Get the available balance for the account involved
        double availableBalance = database.getTotalBalance(getAccountNumber());

        // Get the total balance
        double totalBalance = database.getTotalBalance(getAccountNumber());

        // Display the balance information on the screen
        screen.displayMessageLine("\nBalance Information: ");
        screen.displayMessage(" - Available Balance: ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total Balance");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");
    }
}
