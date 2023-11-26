package token;

public class NumberToken extends Token {

    Number value;

    public NumberToken(Number value) {
        super(value.toString());
        this.value = value;
    }

    @Override
    public boolean isNonEmpty() {
        return value != null;
    }

    @Override
    public double getDoubleValue() {
        return value.doubleValue();
    }

    @Override
    public int compareTo(Token o) {
        return Double.compare(getDoubleValue(), o.getDoubleValue());
    }
}
