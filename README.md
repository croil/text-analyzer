# Text Analyzer

Java text analyzer that parses text in a given language and collects statistics on various tokens:
words, numbers, dates, and currency.
The statistics calculation depends on the locale choice.
For example, the currency token $451 will be interpreted as 451 dollars in the `Locale.US`
but won't be parsed in the `Locale.GERMAN`.
## Information categories
1. `Sentences`
2. `Words`
3. `Dates`
4. `Currencies`
5. `Numbers`

## Collected information
Different information, collected about one type of token. Representation depends on token type.
For example, average value is the arithmetic mean for numbers and currencies, average length for words and sentences.
For dates, it is the overall average date, for example, `Sat Dec 04 00:00:00 MSK 1999
1. `Occurrence` - All token occurrences in the text
2. `Variants` - The number of distinct tokens of this type.
3. `MaxString` - Max token by its string value length
4. `MinString` - Min token by it string value length
5. `MaxValue` - Max token by its own compareTo method
6. `MinValue` - Max token by its own compareTo method
7. `Average` - The average value for tokens.


## Usage
```Java
Locale locale = Locale.getDefault(); // I have en_US locale.
Counter counter = new Counter("Some words, Date: 04/12/1999, currency: $4.5", locale);
Info words = counter.getStatistics(Category.WORD);
Info dates = counter.getStatistics(Category.DATE);
Info currencies = counter.getStatistics(Category.CURRENCY);
System.out.println(words.occurrence()); // 4
System.out.println(words.maxString()); // currency
System.out.println(words.minString()); // Some
System.out.println(dates.occurrence()); // 1
System.out.println(dates.average()); // Mon Apr 12 00:00:00 MSD 1999
System.out.println(currencies.occurrence()); // 1
System.out.println(currencies.average()); // 4.5
```