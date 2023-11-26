package text;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Report {
    private static final String LS = System.lineSeparator();
    private final TextData textData;
    private final ResourceBundle bundle;
    private final BufferedWriter writer;

    public Report(TextData textData, ResourceBundle bundle, BufferedWriter writer) {
        this.textData = textData;
        this.bundle = bundle;
        this.writer = writer;
    }

    public Object[] getTokenObject(Info info, String... bundles) {
        return new Object[]{
                bundles[0],
                bundles[1],
                bundles[2],
                bundles[3],
                bundle.getString("amount"),
                info.occurrence(),
                info.variants(),
                bundle.getString("variants"),
                bundle.getString("minMale"),
                info.minValue(),
                bundle.getString("maxMale"),
                info.maxValue(),
                bundle.getString("length"),
                bundle.getString("minFemale"),
                info.minString().length(),
                info.minString(),
                bundle.getString("maxFemale"),
                info.maxString().length(),
                info.maxString(),
                bundle.getString("middleFemale"),
                info.average(),
                bundle.getString("tab")
        };
    }

    public Object[] getNumberObject(Info info, String... bundles) {
        return new Object[]{
                bundles[0],
                bundles[1],
                bundles[2],
                bundle.getString("Amount"),
                info.occurrence(),
                info.variants(),
                bundle.getString("variants"),
                bundle.getString("minMale"),
                info.minValue(),
                bundle.getString("maxMale"),
                info.maxValue(),
                bundles[3],
                info.average(),
                bundle.getString("tab")
        };
    }

    public void getReport() throws IOException {
        final MessageFormat headerPattern = new MessageFormat("{0} {1}" + LS);
        final MessageFormat mainStatisticsPattern = new MessageFormat(
                "{0}" + LS +
                        "{12}{1} {2}: {3}" + LS +
                        "{12}{1} {4}: {5}" + LS +
                        "{12}{1} {6}: {7}" + LS +
                        "{12}{1} {8}: {9}" + LS +
                        "{12}{1} {10}: {11}" + LS);
        final MessageFormat tokenPattern = new MessageFormat(
                "{3}" + LS +
                        "{21}{4} {0}: {5} ({6} {7})" + LS +
                        "{21}{8} {1}: \"{9}\"" + LS +
                        "{21}{10} {1}: \"{11}\"" + LS +
                        "{21}{13} {12} {2}: {14} (\"{15}\")" + LS +
                        "{21}{16} {12} {2}: {17} (\"{18}\")" + LS +
                        "{21}{19} {12} {2}: {20}" + LS
        );
        final MessageFormat numberPattern = new MessageFormat(
                "{2}" + LS +
                        "{13}{3} {0}: {4} ({5} {6})" + LS +
                        "{13}{7} {1}: {8}" + LS +
                        "{13}{9} {1}: {10}" + LS +
                        "{13}{11} {1}: {12}" + LS
        );
        writer.write(headerPattern.format(new String[]{
                bundle.getString("file"),
                textData.file()
        }));
        writer.write(mainStatisticsPattern.format(new Object[]{
                bundle.getString("mainStatistics"),
                bundle.getString("Amount"),
                bundle.getString("sentences"),
                textData.sentences().occurrence(),
                bundle.getString("words"),
                textData.words().occurrence(),
                bundle.getString("numMul"),
                textData.numbers().occurrence(),
                bundle.getString("curMul"),
                textData.money().occurrence(),
                bundle.getString("dateMul"),
                textData.date().occurrence(),
                bundle.getString("tab")
        }));
        writer.write(tokenPattern.format(getTokenObject(textData.sentences(),
                bundle.getString("sentenceA"),
                bundle.getString("sentenceB"),
                bundle.getString("sentenceC"),
                bundle.getString("sentenceStat")
        )));
        writer.write(tokenPattern.format(getTokenObject(textData.words(),
                bundle.getString("wordA"),
                bundle.getString("wordB"),
                bundle.getString("wordC"),
                bundle.getString("wordStat")
        )));
        writer.write(numberPattern.format(getNumberObject(textData.numbers(),
                bundle.getString("numMul"),
                bundle.getString("number"),
                bundle.getString("numStat"),
                bundle.getString("middleMale")
        )));
        writer.write(numberPattern.format(getNumberObject(textData.money(),
                bundle.getString("curMul"),
                bundle.getString("currency"),
                bundle.getString("currencyStat"),
                bundle.getString("middleFemale")
        )));
        writer.write(numberPattern.format(getNumberObject(textData.date(),
                bundle.getString("dateMul"),
                bundle.getString("date"),
                bundle.getString("dateStat"),
                bundle.getString("middleFemale")
        )));
    }
}