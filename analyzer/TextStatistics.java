import text.Category;
import text.Counter;
import text.Info;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class TextStatistics {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault(); // I have en_US locale.
        Counter counter = new Counter("Some words, Date: 04/12/1999, currency: $4.5", locale);
        Info words = counter.getStatistics(Category.WORD);
        Info dates = counter.getStatistics(Category.DATE);
        Info currencies = counter.getStatistics(Category.CURRENCY);
        System.out.println(words.occurrence()); // 5
        System.out.println(words.maxString()); // currency
        System.out.println(words.minString()); // Some
        System.out.println(dates.occurrence()); // 1
        System.out.println(dates.average()); // Mon Apr 12 00:00:00 MSD 1999
        System.out.println(currencies.occurrence()); // 1
        System.out.println(currencies.average()); // 4.5
    }
}
