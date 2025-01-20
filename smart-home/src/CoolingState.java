// State Pattern
public class CoolingState implements ThermostatState {
    @Override
    public void handle() {
        System.out.println("Thermostat is in Cooling Mode.");
    }
}