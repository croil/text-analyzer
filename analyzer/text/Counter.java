package text;

import parser.CurrencyParser;
import parser.DateParser;
import parser.NumberParser;
import parser.Parser;
import token.StringToken;
import token.Token;

import java.text.BreakIterator;
import java.text.ParsePosition;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Counter {
    private final String text;
    private final Locale locale;

    public Counter(String text, Locale locale) {
        this.text = text;
        this.locale = locale;
        StringComparator.getInstance().initializeCollator(locale);
    }

    public Info getStatistics(Category category) {
        final BreakIterator breakIterator = getBreakIterator(category);
        breakIterator.setText(text);
        return switch (category) {
            case SENTENCE, WORD -> getTokenStatistics(breakIterator, category);
            case CURRENCY, NUMBER, DATE -> getDoubleStatistics(breakIterator, category);
        };
    }


    private Info collectData(List<Token> data, Category category) {
        if (data.isEmpty()) {
            return new Info();
        }
        final Supplier<Stream<Token>> supp = () -> data.stream().filter(Token::isNonEmpty);
        String minValue = supp.get().min(Token::compareTo).orElseThrow().toString();
        String maxValue = supp.get().max(Token::compareTo).orElseThrow().toString();
        String minString = supp.get().map(Token::toString).min(Comparator.comparingInt(String::length)).orElseThrow();
        String maxString = supp.get().map(Token::toString).max(Comparator.comparingInt(String::length)).orElseThrow();
        double sum = supp.get().mapToDouble(Token::getDoubleValue).sum();
        double average = sum / data.size();
        String strAverage = (category == Category.DATE ? new Date((long) average).toString() : Double.toString(average));
        int distinctValue = Math.toIntExact(supp.get().distinct().count());
        return new Info(data.size(), distinctValue, minValue, maxValue, minString, maxString, strAverage);
    }

    private boolean addToken(List<Token> items, Parser parser, ParsePosition pos) {
        final Token token = parser.parse(text, pos);
        if (token.isNonEmpty()) {
            items.add(token);
            return true;
        }
        return false;
    }

    private Info getTokenStatistics(final BreakIterator bI, final Category category) {
        final List<Token> items = new ArrayList<>();
        for (int from = bI.first(), to = bI.next(); to != BreakIterator.DONE; from = to, to = bI.next()) {
            String item = text.substring(from, to).trim();
            if (category == Category.SENTENCE || isWord(item)) {
                items.add(new StringToken(item));
            }
        }
        return collectData(items, category);
    }

    private Info getDoubleStatistics(final BreakIterator bI, final Category category) {
        final List<Token> items = new ArrayList<>();
        final Parser parser = switch (category) {
            case NUMBER -> new NumberParser(locale);
            case CURRENCY -> new CurrencyParser(locale);
            case DATE -> new DateParser(locale);
            default -> null;
        };
        int parseBorder = 0;
        for (int from = bI.first(), to = bI.next(); to != BreakIterator.DONE; from = to, to = bI.next()) {
            ParsePosition position = new ParsePosition(from);
            if (parseBorder <= from) {
                if (parser != null && addToken(items, parser, position)) {
                    parseBorder = position.getIndex();
                }
            }
        }
        return collectData(items, category);
    }

    private boolean isWord(String item) {
        item = item.replaceAll("\\s", "");
        if (item.isEmpty()) return false;
        for (int i = 0; i < item.length(); i++) {
            if (!Character.isLetter(item.charAt(i))) return false;
        }
        return true;
    }

    private BreakIterator getBreakIterator(Category category) {
        if (category == Category.SENTENCE) {
            return BreakIterator.getSentenceInstance(locale);
        }
        return BreakIterator.getWordInstance(locale);
    }
}
