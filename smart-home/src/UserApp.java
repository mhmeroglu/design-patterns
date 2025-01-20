// Concrete Observer
public class UserApp implements DeviceObserver {
    @Override
    public void update(String deviceName, boolean state) {
        System.out.println("UserApp Notification: " + deviceName + " is now " + (state ? "ON" : "OFF"));
    }
}