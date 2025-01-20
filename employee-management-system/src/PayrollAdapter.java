// PayrollAdapter.java
public class PayrollAdapter implements SalaryCalculationStrategy {
    private ExternalPayrollSystem externalPayrollSystem;

    public PayrollAdapter(ExternalPayrollSystem externalPayrollSystem) {
        this.externalPayrollSystem = externalPayrollSystem;
    }

    @Override
    public double calculateSalary(double baseSalary) {
        return externalPayrollSystem.getExternalSalary();
    }
}
