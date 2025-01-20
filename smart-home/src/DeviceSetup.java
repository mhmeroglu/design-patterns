// Template Pattern
public abstract class DeviceSetup {
    public final void setupDevice() {
        initializeHardware();
        configureDevice();
        testDevice();
    }

    protected abstract void initializeHardware();

    protected abstract void configureDevice();

    protected abstract void testDevice();
}
