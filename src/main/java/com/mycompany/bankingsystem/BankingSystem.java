package com.mycompany.bankingsystem;

import java.util.Scanner;

interface InterestCalculator {
    double calculateInterest(double balance);
}

class BankAccount implements InterestCalculator {
    private double accountBalance;

    public BankAccount(String customerName, double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited: $" + amount);
        displayBalance();
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + accountBalance);
    }

    public double getBalance() {
        return accountBalance;
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05; // 5% interest rate
    }
}


public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account
        BankAccount myAccount = new BankAccount("John Doe", 0);

        while (true) {
            // Display menu
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            // Get user choice
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    myAccount.displayBalance();
                    break;
                case 4:
                    double interest = myAccount.calculateInterest(myAccount.getBalance());
                    System.out.println("Interest earned: $" + interest);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
