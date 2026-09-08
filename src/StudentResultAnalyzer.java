import java.util.Scanner;

public class StudentResultAnalyzer {

    public static boolean validateMarks(int math, int science, int english, int computer) {
        return math >= 0 && math <= 100
                && science >= 0 && science <= 100
                && english >= 0 && english <= 100
                && computer >= 0 && computer <= 100;
    }

    public static int calculateTotal(int math, int science, int english, int computer) {
        return math + science + english + computer;
    }

    public static double calculateAverage(int total, int subjects) {
        return (double) total / subjects;
    }

    public static String calculateGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        }
        return "F";
    }

    public static String checkPerformance(String grade) {
        if (grade.equals("A")) {
            return "Excellent";
        } else if (grade.equals("B")) {
            return "Very Good";
        } else if (grade.equals("C")) {
            return "Good";
        } else if (grade.equals("D")) {
            return "Pass";
        }
        return "Fail";
    }

    public static void displayReport(String name, int math, int science,
                                     int english, int computer,
                                     int total, double average,
                                     String grade, String performance) {
        System.out.println("\n===== Student Result Report =====");
        System.out.println("Student Name: " + name);
        System.out.println("Math: " + math);
        System.out.println("Science: " + science);
        System.out.println("English: " + english);
        System.out.println("Computer: " + computer);
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Final Grade: " + grade);
        System.out.println("Performance Status: " + performance);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = input.nextLine().trim();

        System.out.print("Enter Math mark: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid mark.");
            input.next();
            System.out.print("Enter Math mark: ");
        }
        int math = input.nextInt();

        System.out.print("Enter Science mark: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid mark.");
            input.next();
            System.out.print("Enter Science mark: ");
        }
        int science = input.nextInt();

        System.out.print("Enter English mark: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid mark.");
            input.next();
            System.out.print("Enter English mark: ");
        }
        int english = input.nextInt();

        System.out.print("Enter Computer mark: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid mark.");
            input.next();
            System.out.print("Enter Computer mark: ");
        }
        int computer = input.nextInt();

        if (studentName.isEmpty()) {
            System.out.println("Student name cannot be empty.");
        } else if (!validateMarks(math, science, english, computer)) {
            System.out.println("Invalid marks. Please check the student grades.");
        } else {
            int total = calculateTotal(math, science, english, computer);
            int subjectCount = 4;
            double average = calculateAverage(total, subjectCount);
            String grade = calculateGrade(average);
            String performance = checkPerformance(grade);

            displayReport(studentName, math, science, english, computer,
                    total, average, grade, performance);
        }

        input.close();
    }
}
