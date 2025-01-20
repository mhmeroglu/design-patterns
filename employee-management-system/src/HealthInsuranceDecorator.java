// HealthInsuranceDecorator.java
public class HealthInsuranceDecorator extends EmployeeBenefit {
    public HealthInsuranceDecorator(Employee employee) {
        super(employee);
    }

    @Override
    public double calculateSalary(double baseSalary) {
        return employee.calculateSalary(baseSalary) + 200.0;
    }
}
