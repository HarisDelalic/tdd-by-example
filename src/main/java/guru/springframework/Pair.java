package guru.springframework;

import java.util.Objects;

public class Pair {
    private final String fromCurrency;
    private final String toCurrency;

    public Pair(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return this.fromCurrency.equals(pair.fromCurrency) &&
                this.toCurrency.equals(pair.toCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCurrency, toCurrency);
    }
}
