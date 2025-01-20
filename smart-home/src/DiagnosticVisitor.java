//Concrete Visitor
public class DiagnosticVisitor implements DeviceVisitor {
    @Override
    public void visit(Light light) {
        System.out.println("Running diagnostics on Light.");
    }

    @Override
    public void visit(Thermostat thermostat) {
        System.out.println("Running diagnostics on Thermostat.");
    }
}