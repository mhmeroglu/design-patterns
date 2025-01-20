public class Main {
    public static void main(String[] args) {

        System.out.println("=== Strategy Pattern ===");
        // Strategy Pattern örneği:
        // Burada, tam zamanlı (FullTimeStrategy) ve yarı zamanlı (PartTimeStrategy) çalışanlara göre maaş hesaplama stratejileri uygulanır.
        Employee fullTimeEmployee = new Employee("Alice", new FullTimeStrategy());
        Employee partTimeEmployee = new Employee("Bob", new PartTimeStrategy());
        System.out.println(fullTimeEmployee.getName() + " (Full Time) Salary: " + fullTimeEmployee.calculateSalary(4000));
        System.out.println(partTimeEmployee.getName() + " (Part Time) Salary: " + partTimeEmployee.calculateSalary(4000));

        System.out.println("\n=== Adapter Pattern ===");
        // Adapter Pattern örneği:
        // Dış bir maaş hesaplama sistemini (ExternalPayrollSystem) kullanarak maaş hesaplama işlemi yapılır.
        // Bu sistem, mevcut sistemle uyumlu olmadığından bir Adapter ile entegre edilmiştir.
        ExternalPayrollSystem externalSystem = new ExternalPayrollSystem();
        Employee employeeWithExternalPayroll = new Employee("John", new PayrollAdapter(externalSystem));
        System.out.println(employeeWithExternalPayroll.getName() + " Salary from External System (Adapted): " + employeeWithExternalPayroll.calculateSalary(0));

        System.out.println("\n=== Decorator Pattern ===");
        // Decorator Pattern örneği:
        // Bu sayede esnek bir şekilde avantajlar eklenebilir veya çıkarılabilir.
        Employee employeeWithBenefits = new HealthInsuranceDecorator(new TransportAllowanceDecorator(fullTimeEmployee));
        System.out.println(employeeWithBenefits.getName() + " Salary with Benefits (Health Insurance + Transport Allowance): " + employeeWithBenefits.calculateSalary(4000));
        // Çalışan maaşına, sağlık sigortası ve ulaşım yardımı gibi ek avantajlar eklemek için dekoratörler kullanılır.

        System.out.println("\n=== Bridge Pattern ===");
        // Bridge Pattern örneği:
        // Çalışan türleri (FullTimeEmployee, PartTimeEmployee) ve maaş hesaplama stratejileri arasındaki ilişkiyi yönetmek için Bridge Pattern kullanılır.
        EmployeeType bridgeFullTimeEmployee = new FullTimeEmployee(new FullTimeStrategy());
        EmployeeType bridgePartTimeEmployee = new PartTimeEmployee(new PartTimeStrategy());
        System.out.println("Bridge Full Time Employee Salary: " + bridgeFullTimeEmployee.getSalary(4000));
        System.out.println("Bridge Part Time Employee Salary: " + bridgePartTimeEmployee.getSalary(4000));

        System.out.println("\n=== Flyweight Pattern ===");
        // Flyweight Pattern örneği:
        // Flyweight Pattern kullanarak, çalışan detayları (departman ve pozisyon bilgisi) hafızada tekrar edilmeden paylaşılabilir hale getirilir.
        // Bu sayede aynı departman ve pozisyon bilgilerini paylaşan çalışanlar için bellek kullanımı optimize edilir.
        EmployeeDetails devDetails = EmployeeDetailsFactory.getEmployeeDetails("IT", "Developer");
        EmployeeDetails managerDetails = EmployeeDetailsFactory.getEmployeeDetails("IT", "Manager");
        System.out.println("Developer Details - Department: " + devDetails.getDepartment() + ", Position: " + devDetails.getPosition());
        System.out.println("Manager Details - Department: " + managerDetails.getDepartment() + ", Position: " + managerDetails.getPosition());
    }
}
