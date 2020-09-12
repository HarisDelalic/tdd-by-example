package guru.springframework;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair, Integer> rateMap = new HashMap<>();

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public void addRate(String fromCurrency, String toCurrency, int ratio) {
        rateMap.put(new Pair(fromCurrency, toCurrency), ratio);

    }

    public int rate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) return 1;
        return rateMap.get(new Pair(fromCurrency, toCurrency));
    }
}
