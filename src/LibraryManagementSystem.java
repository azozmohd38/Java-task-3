import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Method to display all books
    public static void displayBooks(java.util.List<String> bookNames,
                                    java.util.List<String> authorNames,
                                    java.util.List<Boolean> availabilityStatus) {

        System.out.println("\n========== LIBRARY BOOK LIST ==========");

        for (int i = 0; i < bookNames.size(); i++) {
            System.out.println((i + 1) + ". Book Name   : " + bookNames.get(i));
            System.out.println("   Author      : " + authorNames.get(i));
            System.out.println("   Availability: "
                    + (availabilityStatus.get(i) ? "Available" : "Unavailable"));
            System.out.println("---------------------------------------");
        }
    }

    // Method to search for a book
    public static void searchBook(ArrayList<String> bookNames, String searchName) {

        boolean found = false;

        if (searchName == null || searchName.trim().isEmpty()) {
            System.out.println("Book name cannot be empty.");
            return;
        }

        for (String book : bookNames) {
            if (book.equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Book \"" + searchName + "\" exists in the library.");
        } else {
            System.out.println("Book \"" + searchName + "\" was not found.");
        }
    }

    // Method to borrow a book
    public static void borrowBook(ArrayList<String> bookNames,
                                  ArrayList<Boolean> availabilityStatus,
                                  String bookName) {

        boolean found = false;

        if (bookName == null || bookName.trim().isEmpty()) {
            System.out.println("Book name cannot be empty.");
            return;
        }

        for (int i = 0; i < bookNames.size(); i++) {
            if (bookNames.get(i).equalsIgnoreCase(bookName)) {
                found = true;

                if (availabilityStatus.get(i)) {
                    availabilityStatus.set(i, false);
                    System.out.println("You have successfully borrowed \"" + bookName + "\".");
                } else {
                    System.out.println("Sorry! This book is currently unavailable.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Method to return a book
    public static void returnBook(ArrayList<String> bookNames,
                                  ArrayList<Boolean> availabilityStatus,
                                  String bookName) {

        boolean found = false;

        if (bookName == null || bookName.trim().isEmpty()) {
            System.out.println("Book name cannot be empty.");
            return;
        }

        for (int i = 0; i < bookNames.size(); i++) {
            if (bookNames.get(i).equalsIgnoreCase(bookName)) {
                found = true;
                if (availabilityStatus.get(i)) {
                    System.out.println("Book is already available.");
                } else {
                    availabilityStatus.set(i, true);
                    System.out.println("Book returned successfully.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Method to count available and unavailable books
    public static int[] countBooks(ArrayList<Boolean> availabilityStatus) {

        int availableCount = 0;
        int unavailableCount = 0;

        for (boolean status : availabilityStatus) {
            if (status) {
                availableCount++;
            } else {
                unavailableCount++;
            }
        }

        return new int[]{availableCount, unavailableCount};
    }

    // Method to display the library report
    public static void displayReport(ArrayList<String> bookNames,
                                     ArrayList<Boolean> availabilityStatus) {

        int[] counts = countBooks(availabilityStatus);

        System.out.println("\n========== LIBRARY REPORT ==========");
        System.out.println("Total Books           : " + bookNames.size());
        System.out.println("Available Books       : " + counts[0]);
        System.out.println("Unavailable Books     : " + counts[1]);
        System.out.println("====================================");
    }

    // Main method
    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Lists to store book information
        ArrayList<String> bookNames = new ArrayList<>();
        ArrayList<String> authorNames = new ArrayList<>();
        ArrayList<Boolean> availabilityStatus = new ArrayList<>();

        // Variables
        int choice;
        String bookName;

        // Adding 10 books
        bookNames.add("Java Programming");
        authorNames.add("James Gosling");
        availabilityStatus.add(true);

        bookNames.add("Clean Code");
        authorNames.add("Robert C. Martin");
        availabilityStatus.add(true);

        bookNames.add("The Pragmatic Programmer");
        authorNames.add("Andrew Hunt");
        availabilityStatus.add(true);

        bookNames.add("Data Structures");
        authorNames.add("Mark Allen Weiss");
        availabilityStatus.add(false);

        bookNames.add("Operating Systems");
        authorNames.add("Abraham Silberschatz");
        availabilityStatus.add(true);

        bookNames.add("Database Systems");
        authorNames.add("Raghu Ramakrishnan");
        availabilityStatus.add(true);

        bookNames.add("Computer Networks");
        authorNames.add("Andrew S. Tanenbaum");
        availabilityStatus.add(false);

        bookNames.add("Artificial Intelligence");
        authorNames.add("Stuart Russell");
        availabilityStatus.add(true);

        bookNames.add("Software Engineering");
        authorNames.add("Ian Sommerville");
        availabilityStatus.add(true);

        bookNames.add("Python Crash Course");
        authorNames.add("Eric Matthes");
        availabilityStatus.add(true);

        // Loop to keep displaying the menu
        do {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Display All Books");
            System.out.println("2. Search for a Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display Library Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid choice. Please try again.");
                input.next();
                System.out.print("Enter your choice: ");
            }
            choice = input.nextInt();
            input.nextLine();

            // Switch case for menu options
            switch (choice) {

                case 1:
                    displayBooks(bookNames, authorNames, availabilityStatus);
                    break;

                case 2:
                    System.out.print("Enter book name to search: ");
                    bookName = input.nextLine().trim();
                    searchBook(bookNames, bookName);
                    break;

                case 3:
                    System.out.print("Enter book name to borrow: ");
                    bookName = input.nextLine().trim();
                    borrowBook(bookNames, availabilityStatus, bookName);
                    break;

                case 4:
                    System.out.print("Enter book name to return: ");
                    bookName = input.nextLine().trim();
                    returnBook(bookNames, availabilityStatus, bookName);
                    break;

                case 5:
                    displayReport(bookNames, availabilityStatus);
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        // Close scanner
        input.close();
    }
}
