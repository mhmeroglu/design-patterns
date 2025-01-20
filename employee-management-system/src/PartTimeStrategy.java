// PartTimeStrategy.java
public class PartTimeStrategy implements SalaryCalculationStrategy {
    public double calculateSalary(double baseSalary) {
        return baseSalary * 0.5;
    }
}
