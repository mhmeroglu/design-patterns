// Employee.java
public class Employee {
    private String name;
    private SalaryCalculationStrategy salaryStrategy;

    public Employee(String name, SalaryCalculationStrategy salaryStrategy) {
        this.name = name;
        this.salaryStrategy = salaryStrategy;
    }

    public double calculateSalary(double baseSalary) {
        return salaryStrategy.calculateSalary(baseSalary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalaryCalculationStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public void setSalaryStrategy(SalaryCalculationStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }
}