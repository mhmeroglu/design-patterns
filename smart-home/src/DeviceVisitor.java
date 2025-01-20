// Visitor Interface
public interface DeviceVisitor {
    void visit(Light light);
    void visit(Thermostat thermostat);
}