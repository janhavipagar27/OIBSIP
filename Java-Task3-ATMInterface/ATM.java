package atm;


import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private Account account;
    private Scanner scanner;
    private ArrayList<Transaction> transactions;

    public ATM(Account account) {
        this.account = account;
        scanner = new Scanner(System.in);
        transactions = new ArrayList<>();
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("          ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    showHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.out.println("Current Balance: ₹"
                            + account.getBalance());
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void withdraw() {

        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (account.withdraw(amount)) {

            transactions.add(new Transaction("Withdrawal", amount));

            System.out.println("Withdrawal successful!");
            System.out.println("Remaining Balance: ₹"
                    + account.getBalance());

        } else {
            System.out.println("Insufficient balance!");
        }
    }

    private void deposit() {

        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        account.deposit(amount);

        transactions.add(new Transaction("Deposit", amount));

        System.out.println("Deposit successful!");
        System.out.println("Current Balance: ₹"
                + account.getBalance());
    }

    private void transfer() {

        System.out.print("Enter receiver User ID: ");
        String receiver = scanner.next();

        System.out.print("Enter amount to transfer: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (account.withdraw(amount)) {

            transactions.add(
                    new Transaction("Transfer to " + receiver, amount));

            System.out.println("Transfer successful!");
            System.out.println("Remaining Balance: ₹"
                    + account.getBalance());

        } else {
            System.out.println("Insufficient balance!");
        }
    }

    private void showHistory() {

        System.out.println("\n------ TRANSACTION HISTORY ------");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {

            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}




