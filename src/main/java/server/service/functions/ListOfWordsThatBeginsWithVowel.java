package server.service.functions;

import entity.TextElement;
import entity.impl.Word;
import server.parser.RegexProvider;
import server.service.TextElementUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListOfWordsThatBeginsWithVowel {
    private final Pattern startWithVowelPattern = Pattern.compile(RegexProvider.getInstance().get("startWithVowelRegEx"));

    public List<Word> getList(TextElement text) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Word> allWords = textElementUtil.getUniqueWords(text);
        List<Word> wordsThatBeginsWithVowel = getWordsThatBeginsWithVowel(allWords);
        wordsThatBeginsWithVowel.sort(firstConsonantComparator);
        return wordsThatBeginsWithVowel;
    }

    private final Comparator<Word> firstConsonantComparator = (w1, w2) -> {
        String newW1Value = w1.value().replaceFirst(RegexProvider.getInstance().get("firstLettersVowelRegEx"), "");
        String newW2Value = w2.value().replaceFirst(RegexProvider.getInstance().get("firstLettersVowelRegEx"), "");

        int result = String.CASE_INSENSITIVE_ORDER.compare(newW1Value, newW2Value);
        if (result == 0) {
            result = newW1Value.compareTo(newW2Value);
        }
        return result;
    };

    private List<Word> getWordsThatBeginsWithVowel(List<Word> allWords) {
        List<Word> wordsThatBeginsWithVowel = new ArrayList<>();
        for (Word word : allWords) {
            if (isBeginsWithVowel(word)) {
                wordsThatBeginsWithVowel.add(word);
            }
        }
        return wordsThatBeginsWithVowel;
    }

    private boolean isBeginsWithVowel(Word word) {
        Matcher startWithVowelMatcher = startWithVowelPattern.matcher(word.value());
        //System.out.println("word - "+word.value()+"  ; "+startWithVowelMatcher.matches()+ "  "+startWithVowelMatcher.find());
        return startWithVowelMatcher.matches();
    }
}
