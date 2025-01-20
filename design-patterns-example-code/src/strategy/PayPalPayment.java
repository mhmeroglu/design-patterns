package strategy;

public class PayPalPayment implements  PaymentStrategy{
    private String email;
    private String password;

    public PayPalPayment(String email, String pwd) {
        this.email = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paypal paid successfully.");
    }
}
