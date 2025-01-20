package strategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String name;
    private String dateOfExpiry;

    public CreditCardPayment(String cardNumber, String cvv, String name, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.name = name;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " credit cards paid successfully.");
    }
}
