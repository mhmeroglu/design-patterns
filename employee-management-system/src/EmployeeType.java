// EmployeeType.java
public abstract class EmployeeType {
    protected SalaryCalculationStrategy salaryCalculation;

    public EmployeeType(SalaryCalculationStrategy salaryCalculation) {
        this.salaryCalculation = salaryCalculation;
    }

    public abstract double getSalary(double baseSalary);
}

