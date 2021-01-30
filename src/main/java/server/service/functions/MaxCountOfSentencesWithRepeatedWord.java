package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;
import server.service.exception.ServiceException;

import java.util.List;

public class MaxCountOfSentencesWithRepeatedWord {
    private final TextElementUtil textElementUtil = new TextElementUtil();



    public int getCount(TextElement text) throws ServiceException {
        List<Word> uniqueWords = textElementUtil.getUniqueWords(text);
        int finalCount = 0;
        List<Sentence> sentences = textElementUtil.getAllSentences(text);
        for(Word word : uniqueWords){
            int count = 0;
            for(Sentence sentence : sentences){
                if(textElementUtil.isWordInSentence(sentence,word)) {
                    count++;
                }
            }
            if(count>finalCount){
                finalCount = count;
            }
        }
        return finalCount;
    }



/*    public static void main(String[] args) {
        TextServiceImpl textService = new TextServiceImpl();
        MaxCountOfSentencesWithRepeatedWord maxCountOfSentencesWithRepeatedWord = new MaxCountOfSentencesWithRepeatedWord();
        for(Word word :maxCountOfSentencesWithRepeatedWord.getUniqueWords(textService.getText())){
            System.out.println(word.value());
        }
        System.out.println(maxCountOfSentencesWithRepeatedWord.getCount(textService.getText()));

    }*/
}
