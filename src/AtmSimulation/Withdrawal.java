package AtmSimulation;

public class Withdrawal extends Transaction {
    private final Keypad keypad;
    private final CashDispenser cashDispenser;

    private final static int CANCELED = 6;

    public Withdrawal(int UseraccountNumber, Screen atmScreen, BankDatabase database, Keypad atmkeypad, CashDispenser dispenser) {
        super(UseraccountNumber, atmScreen, database);

        // Initialize reference to the keypad and cash dispenser
        keypad = atmkeypad;
        cashDispenser = dispenser;
    }

    // Perform transaction
    public void execute() {
        boolean cashDispensed = false; // Cash was not dispensed yet
        double availablebalance; // Amount available for withdrawal

        // Get reference to the bank database and screen
        BankDatabase database = getDatabase();
        Screen screen = getScreen();

        // Loop until cash is dispensed or user cancels
        do {
            // Obtain the chosen withdrawal amount from the user
            int amount = displayMenuofAmounts();

            // Check whether the user choose to withdraw or cancel
            if (amount != CANCELED) {
                // Get available balance of account involved
                availablebalance = database.getAvailableBalance(getAccountNumber());

                // Check whether the user has enough money in the account
                if (amount <= availablebalance) {
                    // Check whether the cash dispenser has enough money
                    if (cashDispenser.isSufficientCashAvailable(amount)) {
                        // Update the account involved to reflect the withdrawal
                        database.debit(getAccountNumber(), amount);

                        cashDispenser.dispenseCash(amount);
                        cashDispensed = true;

                        // Instuct user to take cash
                        screen.displayMessageLine("\n your cash has been dispensed please take your cash now!.");
                    } else screen.displayMessageLine("\n temporary to dispense cash");
                } else screen.displayMessageLine("\n Insufficient fund");
            } else {
                screen.displayMessageLine("\nCanceling transaction.....");
                return; // Return to main menu because user canceled
            }
        } while (!cashDispensed);
    }

    private int displayMenuofAmounts() {
        int userChoice = 0; // Local variable to store returned value
        Screen screen = getScreen();

        // Array of amount to correspond to menu numbers
        int[] amounts = {0, 20, 40, 100, 200};

        // Loop while no valid choice have been made
        while (userChoice == 0) {
            screen.displayMessageLine("\n Withdrawal Menu");
            screen.displayMessage("1 - $20");
            screen.displayMessage("2 - $40");
            screen.displayMessage("3 - $60");
            screen.displayMessage("4 - $100");
            screen.displayMessage("5 - $200");
            screen.displayMessage("6 - cancel transaction");
            screen.displayMessageLine("\nChoose a withdrawal amount");

            int input = keypad.GetInput();

            // Determine how to proceed based on the input value
            switch (input) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    userChoice = amounts[input];// Save users choice
                    break;
                case CANCELED:
                    userChoice = CANCELED;
                    break;
                default:
                    screen.displayMessageLine("\nInvalid Selection try again...");
            }
        }

        return userChoice;
    }
}
