import java.util.Scanner;

public class CircleCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declare variables
        final double pi = 3.14;
        double radius;
        double area;
        double circumference;
        String circleType;

        // Prompt the user to enter the radius
        System.out.print("Enter the radius of the circle: ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid radius. Please enter a number.");
            input.next();
            System.out.print("Enter the radius of the circle: ");
        }
        radius = input.nextDouble();

        // Validate the radius
        if (radius <= 0.0) {
            System.out.println("Invalid radius. Radius must be greater than zero.");
        } else {

            // Calculate the area and circumference
            double radiusSquared = radius * radius;
            area = pi * radiusSquared;
            circumference = 2 * pi * radius;

            // Classify the circle based on its radius
            if (radius < 5) {
                circleType = "Small Circle";
            } else if (radius >= 5 && radius <= 15) {
                circleType = "Medium Circle";
            } else {
                circleType = "Large Circle";
            }

            // Display the results
            System.out.println("\n===== Circle Calculator Result =====");
            System.out.printf("Radius: %.2f%n", radius);
            System.out.printf("Area: %.2f%n", area);
            System.out.printf("Circumference: %.2f%n", circumference);
            System.out.println("Classification: " + circleType);
            System.out.println("--------------------------------");
        }

        input.close();
    }
}
