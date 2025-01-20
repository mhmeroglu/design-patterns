// PartTimeEmployee.java
public class PartTimeEmployee extends EmployeeType {
    public PartTimeEmployee(SalaryCalculationStrategy salaryCalculation) {
        super(salaryCalculation);
    }

    @Override
    public double getSalary(double baseSalary) {
        return salaryCalculation.calculateSalary(baseSalary);
    }
}
