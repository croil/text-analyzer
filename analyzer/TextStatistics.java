import text.Category;
import text.Counter;
import text.Info;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class TextStatistics {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    private static boolean isValid(String[] args) {
        if (args == null) {
            System.err.println("No input data");
            return false;
        }
        if (args.length != 4) {
            System.err.println("Lack of arguments");
            return false;
        }
        if (args[0] == null) {
            System.err.println("Invalid input locale");
            return false;
        }
        if (args[1] == null) {
            System.err.println("Invalid output locale");
            return false;
        }
        if (args[2] == null) {
            System.err.println("Invalid input file");
            return false;
        }
        if (args[3] == null) {
            System.err.println("Invalid output file");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Counter counter = new Counter("15.12.2003, $2,193.5656 - dollar", locale);
        Info a = counter.getStatistics(Category.SENTENCE);
        System.out.println(a.occurrence());
    }
}
