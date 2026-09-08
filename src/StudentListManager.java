import java.util.ArrayList;
import java.util.List;

public class StudentListManager {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        students.add("Salim");
        students.add("Sami");
        students.add("Sara");
        students.add("Noor");
        students.add("Mohammed");
        students.add("Fatima");
        students.add("Khalid");
        students.add("Hannah");
        students.add("Ibrahim");
        students.add("Shatha");

        for (String student : students) {
            System.out.println(student);
        }

        System.out.println("Total number of students: " + students.size());
        System.out.println("First Student: " + students.get(0));
        System.out.println("Last Student: " + students.get(students.size() - 1));

        String searchStudent = "Sara";

        if (students.contains(searchStudent)) {
            System.out.println(searchStudent + " is found in the list.");
        } else {
            System.out.println(searchStudent + " is not found in the list.");
        }

        String removeStudent = "Sami";

        if (students.remove(removeStudent)) {
            System.out.println("Removed Student: " + removeStudent);
        } else {
            System.out.println("Student is not found: " + removeStudent);
        }

        System.out.println("\n===== Updated Student List =====");
        for (String student : students) {
            System.out.println(student);
        }
    }
}
