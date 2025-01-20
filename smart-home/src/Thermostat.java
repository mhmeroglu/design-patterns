public class Thermostat implements SmartHomeDevice {
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat temperature set to " + temperature + " degrees.");
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}