// State Pattern
public class HeatingState implements ThermostatState {
    @Override
    public void handle() {
        System.out.println("Thermostat is in Heating Mode.");
    }
}
