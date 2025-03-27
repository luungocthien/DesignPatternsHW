package composite;

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee emp1 = new Employee("John Doe", 5000);
        Employee emp2 = new Employee("Jane Smith", 6000);
        Employee emp3 = new Employee("Emily Davis", 5500);
        Employee emp4 = new Employee("Michael Brown", 7000);
        Employee emp5 = new Employee("Sarah Wilson", 6500);
        Employee emp6 = new Employee("Chris Johnson", 7200);

        // Create departments
        Department hrDepartment = new Department("HR Department");
        Department itDepartment = new Department("IT Department");
        Department financeDepartment = new Department("Finance Department");
        Department subFinanceDepartment = new Department("Sub Finance Department");
        Department subITDepartment = new Department("Sub IT Department");

        // Add employees to departments
        hrDepartment.add(emp1);
        itDepartment.add(emp2);
        financeDepartment.add(emp3);
        subFinanceDepartment.add(emp4);
        subFinanceDepartment.add(emp5);
        subITDepartment.add(emp6);

        // Add sub-departments to departments
        financeDepartment.add(subFinanceDepartment);
        itDepartment.add(subITDepartment);

        // Create a main department and add sub-departments
        Department mainDepartment = new Department("Main Department");
        mainDepartment.add(hrDepartment);
        mainDepartment.add(itDepartment);
        mainDepartment.add(financeDepartment);

        // Display information
        mainDepartment.getInfo();

        // Calculate and display total salary
        System.out.println("Total Salary: " + mainDepartment.totalSalary());

        // Print organizational structure in XML format
        System.out.println(mainDepartment.toXML());
    }
}