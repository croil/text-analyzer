package text;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class StringComparator implements Comparator<String> {

    private static StringComparator instance;
    private Collator collator;

    private StringComparator() {
        this.collator = Collator.getInstance();
    }

    public static StringComparator getInstance() {
        if (instance == null) {
            instance = new StringComparator();
        }
        return instance;
    }
    public void initializeCollator(Locale locale) {
        this.collator = Collator.getInstance(locale);
    }

    @Override
    public int compare(String str1, String str2) {
        return collator.compare(str1, str2);
    }
}
