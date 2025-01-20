// State Pattern
public class ThermostatContext {
    private ThermostatState currentState = new CoolingState(); // Default state

    public void setState(ThermostatState state) {
        this.currentState = state;
    }

    public void applyState() {
        if (currentState != null) {
            currentState.handle();
        } else {
            System.out.println("No state set.");
        }
    }
}