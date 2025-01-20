//Visitor Element Interface
interface SmartHomeDevice {
    void accept(DeviceVisitor visitor);
}