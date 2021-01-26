package server.service.functions;

import entity.TextElement;
import entity.impl.Word;
import server.parser.RegexProvider;
import server.service.TextElementUtil;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListOfWordsByVowelPercentage {


    public List<Word> getList(TextElement text) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Word> allWords = textElementUtil.getUniqueWords(text);
        allWords.sort(vowelPercentageComparator);
        return allWords;
    }

    private final Comparator<Word> vowelPercentageComparator = (o1, o2) ->{
        if (getVowelPercentage(o1) > getVowelPercentage(o2)) {
            return 1;
        } else if (getVowelPercentage(o1) < getVowelPercentage(o2)) {
            return -1;
        } else {
            return o1.value().compareTo(o2.value());
        }
    };

    private double getVowelPercentage(Word word){
        String vowelRegEx = RegexProvider.getInstance().get("vowelRegEx");

        Pattern pattern = Pattern.compile(vowelRegEx);
        Matcher matcher = pattern.matcher(word.value());

        double foundQuantity = 0;

        while (matcher.find()) {
            foundQuantity++;
        }

        return foundQuantity / word.value().length();
    }
}
