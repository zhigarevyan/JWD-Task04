package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;
import server.service.exception.ServiceException;

import java.util.Comparator;
import java.util.List;

public class ListOfWordsSortedByCountOfSentences {
    TextElement text;
    public List<Word> getList(TextElement text, List<Word> words) {
        this.text = text;
        words.sort(countOfOccurrencesComparator);
        return words;
    }

    Comparator<Word> countOfOccurrencesComparator = (w1,w2) ->{
        try {
            return Integer.compare(getCountOfOccurrences(w2), getCountOfOccurrences(w1));
        } catch (ServiceException serviceException) {
            System.err.println("Exception in comparator");
        }
        return 0;
    };


    private int getCountOfOccurrences(Word word) throws ServiceException {
        int count = 0;
        TextElementUtil textElementUtil = new TextElementUtil();

        List<Sentence> sentences = textElementUtil.getAllSentences(text);
        for(Sentence sentence:sentences){
            if(textElementUtil.isWordInSentence(sentence,word)){
                count++;
            }
        }
        return count;
    }
}
