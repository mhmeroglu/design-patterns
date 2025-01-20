// EmployeeDetailsFactory.java
import java.util.HashMap;

public class EmployeeDetailsFactory {
    private static final HashMap<String, EmployeeDetails> employeeDetailsMap = new HashMap<>();

    public static EmployeeDetails getEmployeeDetails(String department, String position) {
        String key = department + ":" + position;
        if (!employeeDetailsMap.containsKey(key)) {
            employeeDetailsMap.put(key, new EmployeeDetails(department, position));
        }
        return employeeDetailsMap.get(key);
    }
}
