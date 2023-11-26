package bundle;

import java.util.ListResourceBundle;

public class UsageResourceBundle_ru extends ListResourceBundle {
    private static final Object[][] CONTENTS = {
            {"file", "Анализируемый файл"},
            {"mainStatistics", "Сводная статистика"},
            {"sentenceStat", "Статистика по предложениям"},
            {"wordStat", "Статистика по словам"},
            {"numStat", "Статистика по числам"},
            {"currencyStat", "Статистика по суммам денег"},
            {"dateStat", "Статистика по датам"},
            {"amount", "Число"},
            {"sentences", "предложений"},
            {"sentenceA", "предложений"},
            {"sentenceB", "предложение"},
            {"sentenceC", "предложения"},
            {"wordA", "слов"},
            {"wordB", "слово"},
            {"wordC", "слова"},
            {"words", "слов"},
            {"currency", "сумма"},
            {"number", "число"},
            {"numMul", "чисел"},
            {"dateMul", "дат"},
            {"date", "дата"},
            {"dates", "дат"},
            {"minMale", "Минимальное"},
            {"maxMale", "Максимальное"},
            {"word", "слово"},
            {"sentence", "предложение"},
            {"minFemale", "Минимальная"},
            {"maxFemale", "Максимальная"},
            {"date", "дата"},
            {"middleFemale", "Средняя"},
            {"variants", "различных"},
            {"length", "длина"},
            {"curMul", "сумм"},
            {"sentenceRP", "предложения"},
            {"middleMale", "Среднее"},
            {"tab", " ".repeat(8)}

    };

    protected Object[][] getContents() {
        return CONTENTS;
    }
}