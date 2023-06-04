package _ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AtmOperationIntr op = new AtmOperationImpl();
        int atmNumber = 12345;
        int atmPin = 123;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to ATM Machine!");

        System.out.print("Enter ATM Number: ");
        int enteredAtmNumber = sc.nextInt();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        System.out.println("****** Welcome to ATM Machine ******");

        if (atmNumber == enteredAtmNumber && atmPin == enteredPin) {
            while (true) {
                System.out.println("1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    op.viewBalance();
                } else if (choice == 2) {
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if (choice == 3) {
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    op.depositAmount(depositAmount);
                } else if (choice == 4) {
                    op.viewMiniStatement();
                } else if (choice == 5) {
                    System.out.println("Thank you for using the ATM Machine. Goodbye!");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN. Exiting...");
            System.exit(0);
        }
    }
}
