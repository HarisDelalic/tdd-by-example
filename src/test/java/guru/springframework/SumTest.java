package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    Expression fiveDollars;
    Expression tenFrancs;
    Bank bank;

    @BeforeEach
    void setUp() {
        fiveDollars = Money.dollar(5);
        tenFrancs = Money.franck(10);

        bank = new Bank();
        bank.addRate("CHF", "USD", 2);
    }

    @Test
    void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        assertEquals(five, ((Sum) result).addend);
        assertEquals(five, ((Sum) result).augend);
    }

    @Test
    void testReduceSumSameCurrency() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testSumDifferentCurrencies() {
        Expression result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");

        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testSumMultiplication() {
        Expression sum = new Sum(fiveDollars, fiveDollars);

        assertEquals(Money.dollar(20), bank.reduce(sum.times(2), "USD"));
    }

}