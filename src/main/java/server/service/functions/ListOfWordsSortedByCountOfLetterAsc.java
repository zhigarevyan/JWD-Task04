package server.service.functions;

import entity.TextElement;
import entity.impl.Word;
import server.service.TextElementUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOfWordsSortedByCountOfLetterAsc {
    private char letter;

    public List<Word> getList(TextElement text, char letter) {
        this.letter = letter;
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Word> allWords = textElementUtil.getUniqueWords(text);
        List<Word> wordsWithLetter = new ArrayList<>();
        for (Word word : allWords) {
            if (countOfLetterInWord(word) > 0) {
                wordsWithLetter.add(word);
            }
        }
        wordsWithLetter.sort(countOfLetterComparator);
        return wordsWithLetter;
    }

    Comparator<Word> countOfLetterComparator = (w1, w2) -> {
        int result;
        if (countOfLetterInWord(w1) > countOfLetterInWord(w2)) {
            result = 1;
        } else if (countOfLetterInWord(w1) < countOfLetterInWord(w2)) {
            result = -1;
        } else {
            result = w1.value().toLowerCase().compareTo(w2.value().toLowerCase());
        }
        return result;
    };

    private int countOfLetterInWord(Word word) {
        int count = 0;
        for (char c : word.value().toCharArray()) {
            if (Character.toLowerCase(c) == letter) {
                count++;
            }
        }
        return count;
    }
}
