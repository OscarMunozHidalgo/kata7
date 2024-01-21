package software.moneyCalculator;

import java.text.DecimalFormat;

public class MoneyConverterCommand implements Command{

    private final Money initialMoney;
    private final Currency currency;

    public MoneyConverterCommand(Money money, Currency currency) {
        this.initialMoney = money;
        this.currency = currency;
    }

    public String execute(){
        double result = convert().getQuantity();
        if(result <= 999999999) {
            DecimalFormat numberFormat = new DecimalFormat("#0.00");
            return numberFormat.format(result);
        }
        return String.format("%6.2e", result);
    }

    public Money convert(){
        return new Money(quantityConverse(currency), currency);
    }

    private double quantityConverse(Currency currency) {
        return initialMoney.getQuantity() * currency.exchangeRate()/initialMoney.getCurrency().exchangeRate();
    }

}
