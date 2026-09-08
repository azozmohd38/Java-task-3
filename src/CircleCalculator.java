import java.util.Scanner;

public class CircleCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Declare variables
        final double pi = 3.14;
        double radius;
        double area;
        double circumference;
        String classification;

        // Prompt the user to enter the radius
        System.out.print("Enter the radius of the circle: ");
        radius = input.nextDouble();

        // Validate the radius
        if (radius <= 0) {
            System.out.println("Invalid radius. Radius must be greater than zero.");
        } else {

            // Calculate the area and circumference
            area = pi * radius * radius;
            circumference = 2 * pi * radius;

            // Classify the circle based on its radius
            if (radius < 5) {
                classification = "Small Circle";
            } else if (radius <= 15) {
                classification = "Medium Circle";
            } else {
                classification = "Large Circle";
            }

            // Display the results
            System.out.println("\n===== Circle Details =====");
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + area);
            System.out.println("Circumference: " + circumference);
            System.out.println("Classification: " + classification);
        }

        // Close the Scanner
        input.close();
    }
}
