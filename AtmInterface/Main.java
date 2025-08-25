
package AtmInterface;

public class Main {
    public static void main(String[] args) {
        // Create a BankAccount with initial balance
        BankAccount userAccount = new BankAccount(5000); // Starting with 5000 balance

        // Create ATM and connect with account
        ATM atm = new ATM(userAccount);

        // Show ATM Menu
        atm.showMenu();
    }
}
