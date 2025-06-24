import java.util.*;

class ATM {
    private double balance = 0;
    private ArrayList<String> miniStatement = new ArrayList<>();
    private final String correctPIN = "1234";

    public boolean login(String pin) {
        return pin.equals(correctPIN);
    }

    public void checkBalance() {
        System.out.println("Your balance is ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            miniStatement.add("Deposited ₹" + amount);
            System.out.println("₹" + amount + " deposited.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            miniStatement.add("Withdrew ₹" + amount);
            System.out.println("₹" + amount + " withdrawn.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showMiniStatement() {
        System.out.println("Mini Statement (Last 5):");
        int count = 0;
        for (int i = miniStatement.size() - 1; i >= 0 && count < 5; i--, count++) {
            System.out.println(miniStatement.get(i));
        }
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter your PIN: ");
        String pin = sc.nextLine();

        if (atm.login(pin)) {
            while (true) {
                System.out.println("\n----- ATM Menu -----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ₹");
                        double dep = sc.nextDouble();
                        atm.deposit(dep);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ₹");
                        double wd = sc.nextDouble();
                        atm.withdraw(wd);
                        break;
                    case 4:
                        atm.showMiniStatement();
                        break;
                    case 5:
                        System.out.println("Thanks for using our ATM!");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        sc.close();
    }
}
