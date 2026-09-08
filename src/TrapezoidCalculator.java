import java.util.Scanner;

public class TrapezoidCalculator {
    public static void main(String[] args) {

        //  variables
        double base1;
        double base2;
        double height;
        double leg1;
        double leg2;
        double area;
        double perimeter;

        String trapezoidType;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the measurements
        System.out.print("Enter the first base: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the first base: ");
        }
        base1 = input.nextDouble();

        System.out.print("Enter the second base: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the second base: ");
        }
        base2 = input.nextDouble();

        System.out.print("Enter the height: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the height: ");
        }
        height = input.nextDouble();

        System.out.print("Enter the first leg: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the first leg: ");
        }
        leg1 = input.nextDouble();

        System.out.print("Enter the second leg: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the second leg: ");
        }
        leg2 = input.nextDouble();

        // Validate the input values
        boolean validMeasurements = base1 > 0 && base2 > 0 && height > 0 && leg1 > 0 && leg2 > 0;

        if (!validMeasurements) {
            System.out.println("Invalid input. All measurements must be greater than zero.");
        } else {

            // Calculate the area and perimeter
            area = ((base1 + base2) * height) / 2.0;
            perimeter = base1 + base2 + leg1 + leg2;

            // Classify the trapezoid based on its perimeter
            if (perimeter < 30) {
                trapezoidType = "Small Trapezoid";
            } else if (perimeter >= 30 && perimeter <= 60) {
                trapezoidType = "Medium Trapezoid";
            } else {
                trapezoidType = "Large Trapezoid";
            }

            // Display the input values
            System.out.println("\n===== Trapezoid Details =====");
            System.out.println("Base 1: " + base1);
            System.out.println("Base 2: " + base2);
            System.out.println("Height: " + height);
            System.out.println("Leg 1: " + leg1);
            System.out.println("Leg 2: " + leg2);

            // Display the calculated results
            System.out.printf("Area: %.2f%n", area);
            System.out.printf("Perimeter: %.2f%n", perimeter);

            // Display the trapezoid classification
            System.out.println("Trapezoid Classification: " + trapezoidType);
        }

        input.close();
    }
}
