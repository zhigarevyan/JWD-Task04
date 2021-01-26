package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;

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
        if(getCountOfOccurrences(w1)>getCountOfOccurrences(w2)){
            return -1;
        }else if(getCountOfOccurrences(w2)>getCountOfOccurrences(w1)){
            return 1;
        }else return 0;
    };


    private int getCountOfOccurrences(Word word){
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
