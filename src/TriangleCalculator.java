import java.util.Scanner;

public class TriangleCalculator {
    public static void main(String[] args) {

        // Declare variables
        double base;
        double height;
        double side1;
        double side2;
        double side3;
        double area;
        double perimeter;

        String triangleType;

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the base
        System.out.print("Enter the base of the triangle: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the base of the triangle: ");
        }
        base = input.nextDouble();

        // Prompt the user to enter the height
        System.out.print("Enter the height of the triangle: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter the height of the triangle: ");
        }
        height = input.nextDouble();

        // Prompt the user to enter the three side lengths
        System.out.print("Enter side 1: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter side 1: ");
        }
        side1 = input.nextDouble();

        System.out.print("Enter side 2: ");
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            input.next();
            System.out.print("Enter side 2: ");
        }
        side2 = input.nextDouble();

        System.out.print("Enter side 3: ");
        side3 = input.nextDouble();

        // Validate the input values
        if (base <= 0 || height <= 0 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.out.println("Invalid input. All values must be greater than zero.");
    } else {

            // Calculate the area and perimeter
            area = (base * height) / 2;
            perimeter = side1 + side2 + side3;

            // Determine the triangle type
            if (side1 == side2 && side2 == side3) {
                triangleType = "Equilateral Triangle";
            } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                triangleType = "Isosceles Triangle";
            } else {
                triangleType = "Scalene Triangle";
            }

            // Display the results
            System.out.println("Base: " + base);
            System.out.println("Height: " + height);
            System.out.println("Side 1: " + side1);
            System.out.println("Side 2: " + side2);
            System.out.println("Side 3: " + side3);
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
            System.out.println("Triangle Type: " + triangleType);
    }

        // Close the Scanner
        input.close();
    }
    }


