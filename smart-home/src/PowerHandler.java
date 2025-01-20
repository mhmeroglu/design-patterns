// Chain of Responsibility Pattern
public class PowerHandler extends RequestHandler {
    @Override
    public void handleRequest(String request) {
        if ("TurnOffDevices".equals(request)) {
            System.out.println("PowerHandler: Turning off all devices.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Request not handled: " + request);
        }
    }
}