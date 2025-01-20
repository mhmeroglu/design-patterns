import java.util.ArrayList;
import java.util.List;

public class FlyweightMemoryTest {
    private static final int EMPLOYEE_COUNT = 100000;
    private static final int TEST_REPEATS = 5;

    public static void main(String[] args) {
        System.out.println("RAM Usage without Flyweight:");
        long memoryWithoutFlyweight = calculateAverageMemoryUsage(FlyweightMemoryTest::calculateMemoryUsageWithoutFlyweight);
        System.out.println("Average Memory used (without Flyweight): " + memoryWithoutFlyweight + " bytes");

        System.out.println("\nRAM Usage with Flyweight:");
        long memoryWithFlyweight = calculateAverageMemoryUsage(FlyweightMemoryTest::calculateMemoryUsageWithFlyweight);
        System.out.println("Average Memory used (with Flyweight): " + memoryWithFlyweight + " bytes");

        long memorySaved = memoryWithoutFlyweight - memoryWithFlyweight;
        System.out.println("\nMemory saved by using Flyweight Pattern: " + memorySaved + " bytes");
    }

    private static long calculateAverageMemoryUsage(MemoryUsageCalculator calculator) {
        long totalMemoryUsage = 0;

        for (int i = 0; i < TEST_REPEATS; i++) {
            System.gc();  // Bellek temizliği çağır
            try {
                Thread.sleep(100);  // Çöp toplayıcının işini tamamlaması için bekleme
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalMemoryUsage += calculator.calculate();
        }
        return totalMemoryUsage / TEST_REPEATS;
    }

    private static long calculateMemoryUsageWithoutFlyweight() {
        List<EmployeeDetails> employees = new ArrayList<>();
        System.gc();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employees.add(new EmployeeDetails("IT", i % 2 == 0 ? "Developer" : "Manager"));
        }

        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return endMemory - startMemory;
    }

    private static long calculateMemoryUsageWithFlyweight() {
        List<EmployeeDetails> employees = new ArrayList<>();
        System.gc();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employees.add(EmployeeDetailsFactory.getEmployeeDetails("IT", i % 2 == 0 ? "Developer" : "Manager"));
        }

        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return endMemory - startMemory;
    }

    @FunctionalInterface
    interface MemoryUsageCalculator {
        long calculate();
    }
}
