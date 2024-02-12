package AtmSimulation;

public class Deposite extends Transaction {
    private double amount;
    private Keypad keypad;
    private DepositeSlut depositeSlut;
    private final static int CANCELED = 0;

    // Deposit constructor
    public Deposite(int userAccountNumber, Screen atmScreen,
                    BankDatabase database, Keypad atmKeypad, DepositeSlut slut) {
        super(userAccountNumber, atmScreen, database);

        keypad = atmKeypad;
        depositeSlut = slut;
    }

    // Perform transaction
    public void execute() {
        BankDatabase database = getDatabase();
        Screen screen = getScreen();

        amount = promptForDepositAmount();

        // Check whether user entered a deposit amount or canceled
        if (amount != CANCELED) {
            screen.displayMessage("\nPlease insert a deposit envelop containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessage(" ");

            // Retrieve deposit envelop
            boolean envelopReceived = depositeSlut.isEnvelopReceived();

            // Check whether envelop was received
            if (envelopReceived) {
                screen.displayMessageLine("\n envelop received.... money deposited to your account");
                database.credit(getAccountNumber(), amount);
            } else {
                screen.displayMessageLine("\nYou did not send an envelop. canceling transaction....");
            }
        } else {
            screen.displayMessageLine("\n Canceling transaction");
        }
    }

    public double promptForDepositAmount() {
        Screen screen = getScreen();

        // Display a prompt
        screen.displayMessage("\nPlease Enter the deposit amount Or 0 to cancel: ");
        int input = keypad.GetInput();

        // Check whether the user canceled or entered a valid amount
        return input;
    }

}
