package parser;


import token.CurrencyToken;
import token.EmptyToken;
import token.Token;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class CurrencyParser implements Parser {
    private final NumberFormat format;

    public CurrencyParser(Locale locale) {
        this.format = NumberFormat.getCurrencyInstance(locale);
    }

    @Override
    public Token parse(String text, ParsePosition pos) {
        Number currency = format.parse(text, pos);
        if (currency == null) {
            return new EmptyToken();
        }
        return new CurrencyToken(currency);
    }
}
