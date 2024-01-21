package software.moneyCalculator;

public class Money{
    private double quantity;
    private Currency currency;

    public Money(double quantity, Currency currency) {
        this.quantity = quantity;
        this.currency = currency;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return quantity + " " + currency.letterCode();
    }
}
