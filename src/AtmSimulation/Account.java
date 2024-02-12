package AtmSimulation;

public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;

    public Account(int theAccountNumber, int thePin, double theAvailableBalance, double theTotal) {
        accountNumber = theAccountNumber;
        pin = thePin;
        availableBalance = theAvailableBalance;
        totalBalance = theTotal;
    }

    // Determine whether the users specified pin matches pin in the account
    public boolean validatePin(int userPIN) {
        if (userPIN == pin)
            return true;
        else
            return false;
    }

    // Return available balance
    public double getAvailableBalance() {
        return availableBalance;
    }

    // Return the total balance
    public double getTotalBalance() {
        return totalBalance;
    }

    // Credit amount to the account
    public void credit(double amount) {
        totalBalance += amount;
    }

    // Debit an amount from the account
    public void debit(double amount) {
        availableBalance -= amount;
        totalBalance -= amount;
    }

    // Return the account number
    public int getAccountNumber() {
        return accountNumber;
    }
}
