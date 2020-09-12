package guru.springframework;

public interface Expression {
    Money reduce(Bank bank, String toCurrency);

    default Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    Expression times(int multiplicator);
}
