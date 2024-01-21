package software.moneyCalculator;

import software.moneyCalculator.viewer.MainFrame;

import java.io.IOException;
import java.util.List;

public class Main {
    //https://v6.exchangerate-api.com/v6/a4fb20e77a139bf7429d8c38/latest/USD
    //debogztxnepuurltvo@ckptr.com
    //123456
    //app.exchangerate-api.com/sign-up
    public static void main(String[] args) throws IOException {

        List<Currency> currencies = new FixerApiCurrencyLoader("https://v6.exchangerate-api.com/v6/a4fb20e77a139bf7429d8c38/latest/USD").load();

        MainFrame mainframe = new MainFrame(currencies);
        mainframe.setVisible(true);
    }

}
