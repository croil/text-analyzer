package token;

import text.StringComparator;

public class StringToken extends Token {

    public StringToken(String token) {
        super(token);
    }

    @Override
    public boolean isNonEmpty() {
        return !token.isEmpty();
    }

    @Override
    public double getDoubleValue() {
        return token.length();
    }

    @Override
    public int compareTo(Token o) {
        return StringComparator.getInstance().compare(this.token, o.token);
    }
}
