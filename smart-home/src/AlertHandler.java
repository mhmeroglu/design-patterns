// Chain of Responsibility Pattern
public class AlertHandler extends RequestHandler {
    @Override
    public void handleRequest(String request) {
        if ("RaiseAlert".equals(request)) {
            System.out.println("AlertHandler: Raising security alert.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Request not handled: " + request);
        }
    }
}