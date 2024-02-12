package AtmSimulation;

public class Screen {
    // Display a message without a carriage return
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Display message with a carriage return
    public void displayMessageLine(String message) {
        System.out.println(message);
    }

    // Display dollar amount
    public void displayDollarAmount(double amount) {
        System.out.printf("$%, .2f",
                amount);
    }
}
