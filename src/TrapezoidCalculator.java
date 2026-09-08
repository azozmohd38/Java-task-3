import java.util.Scanner;

public class TrapezoidCalculator {
    public static void main(String[] args) {

        //  variables
        double base1, base2, height, leg1, leg2, area, perimeter;

        String trapezoidType;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the measurements
        System.out.print("Enter the first base: ");
        base1 = input.nextDouble();

        System.out.print("Enter the second base: ");
        base2 = input.nextDouble();

        System.out.print("Enter the height: ");
        height = input.nextDouble();

        System.out.print("Enter the first leg: ");
        leg1 = input.nextDouble();

        System.out.print("Enter the second leg: ");
        leg2 = input.nextDouble();

        // Validate the input values
        if (base1 <= 0 || base2 <= 0 || height <= 0 || leg1 <= 0 || leg2 <= 0) {
            System.out.println("Invalid input. All measurements must be greater than zero.");
    } else {

            // Calculate the area and perimeter
            area = ((base1 + base2) * height) / 2;
            perimeter = base1 + base2 + leg1 + leg2;

            // Classify the trapezoid based on its perimeter
            if (perimeter < 30) {
                trapezoidType = "Small Trapezoid";
            } else if (perimeter <= 60) {
                trapezoidType = "Medium Trapezoid";
            } else {
                trapezoidType = "Large Trapezoid";
            }

            // Display the input values
            System.out.println("Base 1: " + base1);
            System.out.println("Base 2: " + base2);
            System.out.println("Height: " + height);
            System.out.println("Leg 1: " + leg1);
            System.out.println("Leg 2: " + leg2);

            // Display the calculated results
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);

            // Display the trapezoid classification
            System.out.println("Trapezoid Classification: " + trapezoidType);
    }

        input.close();
    }
}
