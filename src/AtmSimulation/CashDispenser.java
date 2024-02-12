package AtmSimulation;

public class CashDispenser {
    // The default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 500;
    private int count; // number of $20 bills remaining

    public CashDispenser() {
        count = INITIAL_COUNT;
    }
    // Simulate dispensing of specified amount of cash
    public void dispenseCash(int amount) {
        int billsRequired = amount / 20;
        count = billsRequired;
    }

    // Indicate whether the cash dispenser can dispense the desired amount
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20; // number of 20 required
        if (count >= billsRequired)
            return true;
        else
            return false;
    }
}
