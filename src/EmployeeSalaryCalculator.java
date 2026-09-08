public class EmployeeSalaryCalculator {

    // Method to calculate the net salary
    public static double calculateNetSalary(
        double basicSalary,
        double bonus,
        double deduction)
    {


        return basicSalary + bonus - deduction;
    }

    // Method to check the salary status
    public static String checkSalaryStatus(double netSalary) {

        if (netSalary < 500) {
        return "Low Salary";
        } else if (netSalary <= 1500) {
        return "Medium Salary";
        } else {
        return "High Salary";
        }
    }

    // Method to display all salary details
    public static void displaySalaryDetails(String employeeName,
                                        double basicSalary,
                                        double bonus,
                                        double deduction,
                                        double netSalary,
                                        String salaryStatus) {

        System.out.println("===== Employee Salary Details =====");
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("Bonus         : " + bonus);
        System.out.println("Deduction     : " + deduction);
        System.out.println("Net Salary    : " + netSalary);
        System.out.println("Salary Status : " + salaryStatus);
    }

    public static void main(String[] args) {

        // Declare employee information
        String employeeName;
        double basicSalary;
        double bonus;
        double deduction;
        double netSalary;
        String salaryStatus;

        // Assign predefined values
        employeeName = "Ahmed ";
        basicSalary = 1200.00;
        bonus = 300.00;
        deduction = 100.00;

        // Calculate the net salary
        netSalary = calculateNetSalary(basicSalary, bonus, deduction);

        // Determine the salary status
        salaryStatus = checkSalaryStatus(netSalary);

        // Display all salary details
        displaySalaryDetails(employeeName, basicSalary, bonus, deduction, netSalary, salaryStatus);
    }
}
