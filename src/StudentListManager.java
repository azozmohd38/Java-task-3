import java.util.ArrayList;
import java.util.List;

public class StudentListManager {
           public static void main(String[] args) {

               List<String> students = new ArrayList<>();

               // Add at least 10 student names
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

               // Display all student names using a loop
               for (String student : students){
                   System.out.println(student);

                   //Display total  number of students in the list
                   System.out.println("total number of student: "+students.size());


                   //Display the first student in the list
                   System.out.println("Frist number of student: "+students.get(0));

                   //Display the last student in the list
                   System.out.println("Last Student: " + students.get(students.size() - 1));


                   //Check if a specific student name exists in the list using a condition
                   String searchstudent = "Sara";


                   // Check if a specific student exists in the list
                   String searchStudent = "Sara";
                   if (students.contains(searchStudent)) {
                       System.out.println("\n" + searchStudent + " is found in the list.");
                   } else {
                       System.out.println("\n" + searchStudent + " is not found in the list.");

                       // Remove a student from the list
                       String removestudent = "Sami";
                       if (students.contains(removestudent)){
                           System.out.println("\n Removed Student:" + removestudent);
                       }else{
                           System.out.println("\n Student is not found: "+removestudent);

                           // Display the updated list after removing the student
                           System.out.println("\n===== Updated Student List =====");
                           for (String Student : students) {
                               System.out.println(student);
                           }
                       }


                   }

               }
           }
}
