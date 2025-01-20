import java.util.ArrayList;
import java.util.List;

// Mediator Observable
public class SmartDevice {
    private final String name;
    private boolean state;
    private final List<DeviceObserver> observers = new ArrayList<>();

    public SmartDevice(String name) {
        this.name = name;
    }

    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    public void setState(boolean state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for (DeviceObserver observer : observers) {
            try {
                observer.update(name, state);
            } catch (Exception e) {
                System.err.println("Observer notification failed: " + e.getMessage());
            }
        }
    }
}

