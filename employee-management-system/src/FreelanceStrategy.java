// FreelanceStrategy.java
public class FreelanceStrategy implements SalaryCalculationStrategy {
    public double calculateSalary(double baseSalary) {
        return baseSalary * 0.75;
    }
}
