// Import required classes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BankAccountSystem1 {

    // Display all customer accounts
    public static void displayAccounts(List<Integer> accountNumbers,
                                       List<String> customerNames,
                                       List<Double> accountBalances) {

        System.out.println("\n========== ALL ACCOUNTS ==========");

        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println("Account Number : " + accountNumbers.get(i));
            System.out.println("Customer Name  : " + customerNames.get(i));
            System.out.println("Balance        : $" + String.format("%.2f", accountBalances.get(i)));
            System.out.println("-----------------------------------");
        }
    }

    // Deposit money into an account
    public static void depositMoney(List<Integer> accountNumbers,
                                    List<Double> accountBalances,
                                    int accountNumber,
                                    double depositAmount) {

        boolean accountFound = false;

        for (int i = 0; i < accountNumbers.size(); i++) {

            if (accountNumbers.get(i) == accountNumber) {

                accountBalances.set(i, accountBalances.get(i) + depositAmount);

                System.out.println("Deposit Successful!");
                System.out.println("Updated Balance: $" + accountBalances.get(i));

                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money from an account
    public static void withdrawMoney(List<Integer> accountNumbers, List<Double> accountBalances,
                                     int accountNumber,
                                     double withdrawAmount) {

        boolean accountFound = false;

        for (int i = 0; i < accountNumbers.size(); i++) {

            if (accountNumbers.get(i) == accountNumber) {

                accountFound = true;

                // Check if balance is enough
                if (accountBalances.get(i) >= withdrawAmount) {

                    accountBalances.set(i, accountBalances.get(i) - withdrawAmount);

                    System.out.println("Withdrawal Successful!");
                    System.out.println("Remaining Balance: $" + accountBalances.get(i));

                } else {

                    System.out.println("Insufficient Balance.");

                }

                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }

    // Check account balance
    public static void checkBalance(List<Integer> accountNumbers,
                                    List<Double> accountBalances,
                                    int accountNumber) {

        boolean accountFound = false;

        for (int i = 0; i < accountNumbers.size(); i++) {

            if (accountNumbers.get(i) == accountNumber) {

                System.out.println("Current Balance: $" + accountBalances.get(i));
                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account not found.");
        }
    }

    // Calculate account statistics
    public static void calculateStatistics(List<Double> accountBalances) {

        double totalBalance = 0;
        double highestBalance = accountBalances.get(0);
        double lowestBalance = accountBalances.get(0);

        double limit = 5000;
        int accountsAboveLimit = 0;

        // Process balances
        for (double balance : accountBalances) {

            totalBalance += balance;

            if (balance > highestBalance) {
                highestBalance = balance;
            }

            if (balance < lowestBalance) {
                lowestBalance = balance;
            }

            if (balance > limit) {
                accountsAboveLimit++;
            }
        }

        System.out.println("\n========== ACCOUNT STATISTICS ==========");
        System.out.println("Total Money                : $" + totalBalance);
        System.out.println("Highest Balance            : $" + highestBalance);
        System.out.println("Lowest Balance             : $" + lowestBalance);
        System.out.println("Accounts Above $" + limit + " : " + accountsAboveLimit);
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declare variables
        int choice;
        int accountNumber;
        double amount;

        // Create lists
        List<Integer> accountNumbers = new ArrayList<>();
        List<String> customerNames = new ArrayList<>();
        List<Double> accountBalances = new ArrayList<>();

        // Add 10 predefined accounts
        accountNumbers.add(1001);
        customerNames.add("Ali");
        accountBalances.add(3500.00);

        accountNumbers.add(1002);
        customerNames.add("Sara");
        accountBalances.add(6200.50);

        accountNumbers.add(1003);
        customerNames.add("Ahmed");
        accountBalances.add(1800.75);

        accountNumbers.add(1004);
        customerNames.add("Fatima");
        accountBalances.add(7200.00);

        accountNumbers.add(1005);
        customerNames.add("Omar");
        accountBalances.add(4500.25);

        accountNumbers.add(1006);
        customerNames.add("Noor");
        accountBalances.add(8100.60);

        accountNumbers.add(1007);
        customerNames.add("Hassan");
        accountBalances.add(950.00);

        accountNumbers.add(1008);
        customerNames.add("Aisha");
        accountBalances.add(5400.80);

        accountNumbers.add(1009);
        customerNames.add("Khalid");
        accountBalances.add(2500.40);

        accountNumbers.add(1010);
        customerNames.add("Mona");
        accountBalances.add(6800.30);

        // Display menu until Exit
        do {

            System.out.println("\n========== BANK ACCOUNT SYSTEM ==========");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Display Account Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    displayAccounts(accountNumbers, customerNames, accountBalances);
                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    amount = input.nextDouble();

                    depositMoney(accountNumbers, accountBalances, accountNumber, amount);
                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    System.out.print("Enter Withdrawal Amount: ");
                    amount = input.nextDouble();

                    withdrawMoney(accountNumbers, accountBalances, accountNumber, amount);
                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    accountNumber = input.nextInt();

                    checkBalance(accountNumbers, accountBalances, accountNumber);
                    break;

                case 5:

                    calculateStatistics(accountBalances);
                    break;

                case 6:

                    System.out.println("Thank you for using the Bank Account System.");
                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }

        } while (choice != 6);

        input.close();
    }
}
