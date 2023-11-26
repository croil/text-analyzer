package parser;


import token.DateToken;
import token.EmptyToken;
import token.Token;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public class DateParser implements Parser {

    private final DateFormat shortFormat;
    private final DateFormat mediumFormat;
    private final DateFormat longFormat;
    private final DateFormat fullFormat;

    public DateParser(final Locale locale) {
        this.shortFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        this.mediumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        this.longFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        this.fullFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
    }

    public Token parse(String text, ParsePosition position) {
        Date date;
        final int start = position.getIndex();
        if ((date = shortFormat.parse(text, position)) == null) {
            if ((date = mediumFormat.parse(text, position)) == null) {
                if ((date = longFormat.parse(text, position)) == null) {
                    date = fullFormat.parse(text, position);
                }
            }
        }
        if (date == null) {
            return new EmptyToken();
        }
        final String strDate = text.substring(start, position.getIndex()).trim();
        return new DateToken(date, strDate);
    }
}
