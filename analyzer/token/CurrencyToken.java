package token;

public class CurrencyToken extends Token {
    private final Number currency;

    public CurrencyToken(Number currency) {
        super(currency.toString());
        this.currency = currency;
    }

    @Override
    public boolean isNonEmpty() {
        return currency != null;
    }

    @Override
    public double getDoubleValue() {
        return currency.doubleValue();
    }

    @Override
    public int compareTo(Token o) {
        return Double.compare(currency.doubleValue(), o.getDoubleValue());
    }
}
