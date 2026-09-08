
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BankAccountSystem {

    public static void displayAccounts(List<Integer> accountNumbers,
                                       List<String> customerNames,
                                       List<Double> balances) {

        System.out.println("\n========== ACCOUNT DETAILS ==========");

        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println("Account Number : " + accountNumbers.get(i));
            System.out.println("Customer Name  : " + customerNames.get(i));
            System.out.println("Balance        : $" + String.format("%.2f", balances.get(i)));
            System.out.println("-------------------------------------");
        }
    }

    // Method to deposit money into an account
    public static void depositMoney(List<Integer> accountNumbers,
                                    List<Double> balances,
                                    int accountNumber,
                                    double amount) {

        boolean found = false;

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accountNumber) {
                balances.set(i, balances.get(i) + amount);
                System.out.println("Deposit successful.");
                System.out.println("New Balance: $" + String.format("%.2f", balances.get(i)));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    public static void withdrawMoney(List<Integer> accountNumbers,
                                     List<Double> balances,
                                     int accountNumber,
                                     double amount) {

        boolean found = false;

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accountNumber) {

                // Check if enough balance exists
                if (balances.get(i) >= amount) {
                    balances.set(i, balances.get(i) - amount);
                    System.out.println("Withdrawal successful.");
                    System.out.println("Remaining Balance: $" + String.format("%.2f", balances.get(i)));
                } else {
                    System.out.println("Insufficient balance.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }
    }

    // Method to check account balance
    public static void checkBalance(List<Integer> accountNumbers,
                                    List<Double> balances,
                                    int accountNumber) {

        boolean found = false;

        for (int i = 0; i < accountNumbers.size(); i++) {
            if (accountNumbers.get(i) == accountNumber) {
                System.out.println("Current Balance: $" + String.format("%.2f", balances.get(i)));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found.");
        }
    }

    // Method to calculate account statistics
    public static void calculateStatistics(List<Double> balances) {

        double total = 0;
        double highest = balances.get(0);
        double lowest = balances.get(0);

        for (double balance : balances) {
            total += balance;

            if (balance > highest) {
                highest = balance;
            }

            if (balance < lowest) {
                lowest = balance;
            }
        }

        System.out.println("\n========== ACCOUNT STATISTICS ==========");
        System.out.println("Total Money in All Accounts : $" + String.format("%.2f", total));
        System.out.println("Highest Account Balance     : $" + String.format("%.2f", highest));
        double average = total / balances.size();
        int highBalanceAccounts = 0;

        for (double balance : balances) {
            if (balance > 3000) {
                highBalanceAccounts++;
            }
        }
        System.out.println("Lowest Account Balance      : $" + String.format("%.2f", lowest));
        System.out.println("Average Account Balance     : $" + String.format("%.2f", average));
        System.out.println("Accounts Above $3000        : " + highBalanceAccounts);
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create lists to store account information
        List<Integer> accountNumbers = new ArrayList<>();
        List<String> customerNames = new ArrayList<>();
        List<Double> balances = new ArrayList<>();

        // Add predefined customer accounts
        accountNumbers.add(1001);
        customerNames.add("Ali");
        balances.add(2500.00);

        accountNumbers.add(1002);
        customerNames.add("Sara");
        balances.add(4200.50);

        accountNumbers.add(1003);
        customerNames.add("Ahmed");
        balances.add(1800.75);

        accountNumbers.add(1004);
        customerNames.add("Fatima");
        balances.add(5300.00);

        accountNumbers.add(1005);
        customerNames.add("Mohammed");
        balances.add(3100.25);

        accountNumbers.add(1006);
        customerNames.add("Noor");
        balances.add(2750.00);

        accountNumbers.add(1007);
        customerNames.add("Omar");
        balances.add(6400.00);

        accountNumbers.add(1008);
        customerNames.add("Mona");
        balances.add(950.50);

        accountNumbers.add(1009);
        customerNames.add("Khalid");
        balances.add(7200.75);

        accountNumbers.add(1010);
        customerNames.add("Aisha");
        balances.add(3900.00);

        int choice;

        // Display menu until the user chooses Exit
        do {

            System.out.println("\n========== BANK ACCOUNT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Display Account Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid choice. Please select a number from 1 to 6.");
                input.next();
                System.out.print("Enter your choice: ");
            }
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    displayAccounts(accountNumbers, customerNames, balances);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccount = input.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = input.nextDouble();

                    depositMoney(accountNumbers, balances, depositAccount, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccount = input.nextInt();

                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = input.nextDouble();

                    withdrawMoney(accountNumbers, balances, withdrawAccount, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int balanceAccount = input.nextInt();

                    checkBalance(accountNumbers, balances, balanceAccount);
                    break;

                case 5:
                    calculateStatistics(balances);
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Account Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 6.");
            }

        } while (choice != 6);

        input.close();
    }
}
