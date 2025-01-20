package strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context;

        context = new PaymentContext(new CreditCardPayment("1234-5678-3456", "333", "John", "12.12.2024"));
        context.payAmount(250);

        context.setPaymentStrategy(new PayPalPayment("john@gmail.com", "john1234"));
        context.payAmount(250);
    }
}
