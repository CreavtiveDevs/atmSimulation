package AtmSimulation;

import java.util.Objects;

public class BankDatabase {
    // Get array of the accounts
    private final Account[] accounts;

    // Constructor
    public BankDatabase() {
        accounts = new  Account[2];
        accounts[0] = new Account(234725, 1234, 1000.0, 1200.0);
        accounts[1] = new Account(12345678, 2468, 2200.0, 2200.0);
    }

    // Retrieve account object containing specified account number
    private Account getAccount(int accountNumber) {
        // Loop through account searching for the matching account number
        for (Account currentAccount : accounts)
            if (currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        return  null;
    }

    // Determine whether user specified account number and pin match those in the database
    public boolean authenticateUser(int accountNumber, int userPIN) {
        // Attempt to retrieve the account with the account number
        Account userAccount = getAccount(accountNumber);

        if (userAccount != null)
            return userAccount.validatePin(userPIN);
        else
            return false;
    }

    // Return available balance of account with account number
    public double getAvailableBalance(int userAccountNumber) {
        return Objects.requireNonNull(getAccount(userAccountNumber)).getAccountNumber();
    }

    // Return total balance of account
    public double getTotalBalance(int userAccountNumber) {
        return Objects.requireNonNull(getAccount(userAccountNumber)).getTotalBalance();
    }

    // Credit an amount to account with specified account number
    public void credit(int userAccountNumber, double amount) {
        Objects.requireNonNull(getAccount(userAccountNumber)).credit(amount);
    }

    // Debit an amount from account with specified account number
    public void debit(int userAccountNumber, double amount) {
        Objects.requireNonNull(getAccount(userAccountNumber)).debit(amount);
    }

}
