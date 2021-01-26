package server.service.functions;

import entity.TextElement;
import entity.impl.Word;
import server.service.TextElementUtil;

import java.util.List;

public class RemoveStartLettersFromWords {

    public TextElement getText(TextElement text) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Word> allWords =  textElementUtil.getAllWords(text);
        for(Word word : allWords){
            word.setWord(getNewWord(word));
        }
        return text;
    }

    private String getNewWord(Word word) {
        char firstChar = Character.toLowerCase(word.value().toCharArray()[0]);
        return word.value().replaceAll("["+firstChar+Character.toUpperCase(firstChar)+"]","");
    }
}
