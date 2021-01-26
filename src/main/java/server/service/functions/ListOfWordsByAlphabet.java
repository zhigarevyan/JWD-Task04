package server.service.functions;

import entity.TextElement;
import entity.impl.Word;
import server.service.TextElementUtil;

import java.util.Comparator;
import java.util.List;

public class ListOfWordsByAlphabet {

    public List<Word> getList(TextElement text) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Word> allWords = textElementUtil.getUniqueWords(text);
        allWords.sort(alphabetComparator);
        return allWords;
    }

    private final Comparator<Word> alphabetComparator = (o1, o2) -> {
        int result = String.CASE_INSENSITIVE_ORDER.compare(o1.value(),o2.value());
        if(result==0){
            result = o1.value().compareTo(o2.value());
        }
        return result;
    };
}
