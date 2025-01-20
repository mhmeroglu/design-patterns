// FullTimeEmployee.java
public class FullTimeEmployee extends EmployeeType {
    public FullTimeEmployee(SalaryCalculationStrategy salaryCalculation) {
        super(salaryCalculation);
    }

    @Override
    public double getSalary(double baseSalary) {
        return salaryCalculation.calculateSalary(baseSalary);
    }
}
