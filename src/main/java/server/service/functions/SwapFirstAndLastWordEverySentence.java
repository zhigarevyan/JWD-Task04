package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;
import server.service.exception.ServiceException;

import java.util.List;

public class SwapFirstAndLastWordEverySentence {

    public TextElement swap(TextElement text) throws ServiceException {
        TextElementUtil textElementUtil = new TextElementUtil();

        for(Sentence sentence: textElementUtil.getAllSentences(text)){
            List<Word> wordsFromSentence = textElementUtil.getAllWordsFromSentence(sentence);
            Word firstWord = wordsFromSentence.get(0);
            Word lastWord = wordsFromSentence.get(wordsFromSentence.size()-1);
            String tempValue = firstWord.value();
            firstWord.setWord(lastWord.value());
            lastWord.setWord(tempValue);
        }
        return  text;
    }
}
