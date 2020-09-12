package guru.springframework;

public class Sum implements Expression {
    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String toCurrency) {
        int result = augend.reduce(bank, toCurrency).amount + addend.reduce(bank, toCurrency).amount;

        return new Money(result, toCurrency);
    }

    @Override
    public Expression times(int multiplicator) {
        return augend.times(multiplicator).plus(addend.times(multiplicator));
    }
}
