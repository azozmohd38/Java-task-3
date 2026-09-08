import java.util.ArrayList;
import java.util.List;

public class NumberListStatistics {
    public static void main(String[] args) {


        // Create a List to store integer numbers
        List<Integer> numbers = new ArrayList<>();

        // Add at least 20 integer values
        numbers.add(10);
        numbers.add(-5);
        numbers.add(0);
        numbers.add(18);
        numbers.add(-12);
        numbers.add(25);
        numbers.add(8);
        numbers.add(-3);
        numbers.add(14);
        numbers.add(7);
        numbers.add(-20);
        numbers.add(30);
        numbers.add(1);
        numbers.add(-9);
        numbers.add(22);
        numbers.add(15);
        numbers.add(6);
        numbers.add(-1);
        numbers.add(40);
        numbers.add(-7);

        // Create variables to store statistics
        int totalSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        // Initialize largest and smallest using the first number
        int largestNumber = numbers.get(0);
        int smallestNumber = numbers.get(0);

        // Display all numbers
        System.out.println("===== Number List =====");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Process each number in the list
        for (int number : numbers) {

            // Calculate the total sum
            totalSum += number;

            // Check if the number is even or odd
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            // Check if the number is positive or negative
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }

            // Find the largest number
            if (number > largestNumber) {
                largestNumber = number;
            }

            // Find the smallest number
            if (number < smallestNumber) {
                smallestNumber = number;
            }
        }

        // Calculate the average
        int totalNumbers = numbers.size();
        double average = (double) totalSum / totalNumbers;

        // Display the results
        System.out.println("\n===== Statistics =====");
        System.out.println("Sum of Numbers: " + totalSum);
        System.out.printf("Average Value: %.2f%n", average);
        System.out.println("Largest Number: " + largestNumber);
        System.out.println("Smallest Number: " + smallestNumber);
        System.out.println("Count of Even Numbers: " + evenCount);
        System.out.println("Count of Odd Numbers: " + oddCount);
        System.out.println("Count of Positive Numbers: " + positiveCount);
        System.out.println("Count of Negative Numbers: " + negativeCount);
    }
}
