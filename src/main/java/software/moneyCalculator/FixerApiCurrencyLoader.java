package software.moneyCalculator;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FixerApiCurrencyLoader implements CurrencyLoader {
    private URL url;
    private static Date lastUpdate;

    public FixerApiCurrencyLoader(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    @Override
    public List<Currency> load() throws IOException {
        URLConnection urlConnection = url.openConnection();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
            return load(reader);
        }catch (IOException e){
            return null;
        }
    }

    private List<Currency> load(BufferedReader reader) {
        return reader.lines().skip(10).filter(s->!s.contains("}")).map(this::toCurrency).collect(toList());
    }

    private Currency toCurrency(String s) {
        return toCurrency(s.split(":"));
    }

    private Currency toCurrency(String[] data) {
        if (data.length != 2) return null;
        return new Currency(
                data[0].replace("\"","").trim(),
                Double.parseDouble(data[1].replace(",",""))
        );

    }
}
