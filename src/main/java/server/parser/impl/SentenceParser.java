package server.parser.impl;

import entity.TextElement;
import entity.impl.Digit;
import entity.impl.PunctuationMark;
import entity.impl.Sentence;
import entity.impl.Word;
import server.parser.Parser;
import server.parser.RegexProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private final Pattern partOfSentencePattern;
    private final Pattern wordPattern;
    private final Pattern digitPattern;

    public SentenceParser() {
        partOfSentencePattern = Pattern.compile(RegexProvider.getInstance().get("partOfSentenceRegEx"));
        wordPattern = Pattern.compile(RegexProvider.getInstance().get("wordRegEx"));
        digitPattern = Pattern.compile(RegexProvider.getInstance().get("digitRegEx"));
    }

    @Override
    public TextElement parse(String textToParse) {
        Sentence sentence = new Sentence();
        Matcher partOfSentenceMatcher = partOfSentencePattern.matcher(textToParse);

        while (partOfSentenceMatcher.find()) {
            String stringPartOfSentence = partOfSentenceMatcher.group();
            if (wordPattern.matcher(stringPartOfSentence).matches()) {
                sentence.add(new Word(stringPartOfSentence));
            } else if (digitPattern.matcher(stringPartOfSentence).matches()) {
                sentence.add(new Digit(stringPartOfSentence));
            } else if (!stringPartOfSentence.equals(" ")) {
                sentence.add(new PunctuationMark(stringPartOfSentence));
            }
        }
        return sentence;
    }
}

