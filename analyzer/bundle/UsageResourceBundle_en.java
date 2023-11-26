package bundle;

import java.util.ListResourceBundle;

public class UsageResourceBundle_en extends ListResourceBundle {
    private static final Object[][] CONTENTS = {
            {"file", "Analyzed file"},
            {"mainStatistics", "Summary statistics"},
            {"sentenceStat", "Sentences statistics"},
            {"wordStat", "Statistics by words"},
            {"numStat", "Statistics by numbers"},
            {"currencyStat", "Money statistics"},
            {"dateStat", "Statistics by dates"},
            {"amount", "Number"},
            {"sentences", "sentences"},
            {"sentenceA", "sentences"},
            {"sentenceB", "sentences"},
            {"sentenceC", "sentences"},
            {"wordA", "word"},
            {"wordB", "word"},
            {"wordC", "word"},
            {"words", "word"},
            {"currency", "sum"},
            {"number", "number"},
            {"numMul", "number"},
            {"dateMul", "date"},
            {"date", "date"},
            {"dates", "dates"},
            {"minMale", "Min"},
            {"maxMale", "Max"},
            {"word", "word"},
            {"sentence", "sentence"},
            {"minFemale", "Min"},
            {"maxFemale", "Max"},
            {"date", "date"},
            {"middleFemale", "Medium"},
            {"variants", "different"},
            {"length", "length"},
            {"curMul", "Sum"},
            {"sentenceRP", "sentences"},
            {"middleMale", "Middle"},
            {"tab", " ".repeat(8)}
    };

    protected Object[][] getContents() {
        return CONTENTS;
    }
}