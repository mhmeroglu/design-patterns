// TransportAllowanceDecorator.java
public class TransportAllowanceDecorator extends EmployeeBenefit {
    public TransportAllowanceDecorator(Employee employee) {
        super(employee);
    }

    @Override
    public double calculateSalary(double baseSalary) {
        return employee.calculateSalary(baseSalary) + 100.0;
    }
}
