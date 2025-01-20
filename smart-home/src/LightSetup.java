// Template Pattern Concrete Implementation
public class LightSetup extends DeviceSetup {
    @Override
    protected void initializeHardware() {
        System.out.println("Initializing Light hardware.");
    }

    @Override
    protected void configureDevice() {
        System.out.println("Configuring Light settings.");
    }

    @Override
    protected void testDevice() {
        System.out.println("Testing Light functionality.");
    }
}