package parser;


import token.EmptyToken;
import token.NumberToken;
import token.Token;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements Parser {

    private final NumberFormat format;

    public NumberParser(Locale locale) {
        this.format = NumberFormat.getNumberInstance(locale);
    }

    @Override
    public Token parse(String text, ParsePosition pos) {
        Number number = format.parse(text, pos);
        return number != null ? new NumberToken(number) : new EmptyToken();
    }
}
