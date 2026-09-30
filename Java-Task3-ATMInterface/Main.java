package atm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("=================================");

        int attempts = 0;
        Account account = null;

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String userId = scanner.next();

            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            account = bank.authenticate(userId, pin);

            if (account != null) {
                System.out.println("\nLogin successful!");
                break;
            }

            attempts++;

            System.out.println("Invalid User ID or PIN.");
            System.out.println("Attempts remaining: " + (3 - attempts));
        }

        if (account == null) {

            System.out.println("\nMaximum login attempts reached.");
            System.out.println("Account access blocked.");

        } else {

            ATM atm = new ATM(account);
            atm.start();
        }

        scanner.close();
    }


	}


