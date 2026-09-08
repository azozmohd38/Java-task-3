public class EmployeeSalaryCalculator {

    // Method to calculate the net salary
    public static double calculateNetSalary(double basicSalary,
                                            double bonusAmount,
                                            double deductionAmount) {
        return basicSalary + bonusAmount - deductionAmount;
    }

    // Method to check the salary status
    public static String checkSalaryStatus(double netSalary) {

        if (netSalary < 500) {
            return "Low Salary";
        } else if (netSalary >= 500 && netSalary <= 1500) {
            return "Medium Salary";
        } else {
            return "High Salary";
        }
    }

    // Method to display all salary details
    public static void displaySalaryDetails(String employeeName,
                                        double basicSalary,
                                        double bonusAmount,
                                        double deductionAmount,
                                        double netSalary,
                                        String salaryStatus) {

        System.out.println("===== Employee Salary Report =====");
        System.out.println("Employee Name : " + employeeName);
        System.out.printf("Basic Salary  : %.2f%n", basicSalary);
        System.out.printf("Bonus         : %.2f%n", bonusAmount);
        System.out.printf("Deduction     : %.2f%n", deductionAmount);
        System.out.printf("Net Salary    : %.2f%n", netSalary);
        System.out.println("Salary Status : " + salaryStatus);
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        // Declare employee information
        String employeeName;
        double basicSalary;
        double bonusAmount;
        double deductionAmount;
        double netSalary;
        String salaryStatus;

        // Assign predefined values
        employeeName = "Ahmed";
        basicSalary = 1200.00;
        bonusAmount = 300.00;
        deductionAmount = 100.00;

        // Calculate the net salary
        netSalary = calculateNetSalary(basicSalary, bonusAmount, deductionAmount);

        // Determine the salary status
        salaryStatus = checkSalaryStatus(netSalary);

        // Display all salary details
        displaySalaryDetails(employeeName, basicSalary, bonusAmount, deductionAmount, netSalary, salaryStatus);
    }
}
