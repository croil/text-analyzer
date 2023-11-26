package token;

import java.util.Date;

public class DateToken extends Token {

    private final Date date;

    public DateToken(Date date, String strDate) {
        super(strDate);
        this.date = date;
    }

    @Override
    public boolean isNonEmpty() {
        return date != null;
    }

    @Override
    public double getDoubleValue() {
        return date.getTime();
    }

    @Override
    public int compareTo(Token o) {
        return Double.compare(date.getTime(), o.getDoubleValue());
    }
}
