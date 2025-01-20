// EmployeeBenefit.java
public abstract class EmployeeBenefit extends Employee {
    public Employee employee;

    public EmployeeBenefit(Employee employee) {
        super(employee.getName(), employee.getSalaryStrategy());
        this.employee = employee;
    }

    public abstract double calculateSalary(double baseSalary);
}

