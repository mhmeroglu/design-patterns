public class Light implements SmartHomeDevice {
    private boolean isOn;

    public void toggle() {
        isOn = !isOn;
        System.out.println("Light is now " + (isOn ? "ON" : "OFF"));
    }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}