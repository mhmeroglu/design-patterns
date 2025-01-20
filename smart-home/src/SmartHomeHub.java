import java.util.HashMap;
import java.util.Map;


// Mediator Pattern
public class SmartHomeHub {
    private final Map<String, SmartDevice> devices = new HashMap<>();

    public void registerDevice(String name, SmartDevice device) {
        devices.put(name, device);
    }

    public void unregisterDevice(String name) {
        devices.remove(name);
    }

    public void sendCommand(String deviceName, boolean state) {
        if (devices.containsKey(deviceName)) {
            devices.get(deviceName).setState(state);
            System.out.println("Hub: Command sent to " + deviceName);
        } else {
            System.out.println("Hub: Device not found.");
        }
    }
}