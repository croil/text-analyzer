package token;

public abstract class Token implements Comparable<Token> {

    protected final String token;

    public Token(String token) {
        this.token = token;
    }

    public abstract boolean isNonEmpty();
    @Override
    public String toString() {
        return token;
    }

    public abstract double getDoubleValue();
}