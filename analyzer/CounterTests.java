package analyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;

public class CounterTests {
    private static Locale localeRu;
    private static Locale localeEn;

    @BeforeClass
    public static void beforeClass() {
        localeRu = new Locale.Builder().setLanguageTag("ru").setRegion("RU").setScript("Cyrl").build();
        localeEn = new Locale.Builder().setLanguageTag("en").setRegion("EN").setScript("Cyrl").build();
    }


    @Test
    public void test() {
        String text = "Message";

    }

}
