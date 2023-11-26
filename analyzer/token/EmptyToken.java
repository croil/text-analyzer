package token;

public class EmptyToken extends Token {

    public EmptyToken() {
        super("");
    }

    @Override
    public boolean isNonEmpty() {
        return false;
    }

    @Override
    public double getDoubleValue() {
        return 0;
    }

    @Override
    public int compareTo(Token o) {
        return 0;
    }
}
