package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;
import server.service.exception.ServiceException;

import java.util.List;

public class WordInFirstSentenceThatNotExistInOthers {

    public Word getWord(TextElement text) throws ServiceException {
        Word resultWord = null;
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Sentence> allSentences = textElementUtil.getAllSentences(text);
        Sentence firstSentence = allSentences.get(0);
        for(Word word : textElementUtil.getAllWordsFromSentence(firstSentence)) {
            resultWord = word;
            for (Sentence sentence : allSentences) {
                if(textElementUtil.isWordInSentence(sentence,word)){
                    break;
                }
            }
        }
        return resultWord;
    }

/*    public static void main(String[] args) {
        TextService textService = new TextServiceImpl();
        System.out.println(new WordInFirstSentenceThatNotExistInOthers().getWord(textService.getText()).value());
    }*/

}
