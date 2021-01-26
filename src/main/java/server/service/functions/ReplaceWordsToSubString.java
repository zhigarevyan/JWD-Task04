package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;

import java.util.List;

public class ReplaceWordsToSubString {
    private TextElementUtil textElementUtil;

    public TextElement getText(TextElement text,int length, String subString) {
        textElementUtil = new TextElementUtil();
        List<Sentence> sentences = textElementUtil.getAllSentences(text);
        for(Sentence sentence: sentences){
            replaceWordToSubString(sentence,length,subString);
        }
        return text;
    }

    private void replaceWordToSubString(Sentence sentence,int length, String subString) {
        List<Word> words = textElementUtil.getAllWordsFromSentence(sentence);
        for(Word word : words){
            if(word.value().length()==length) {
                word.setWord(subString);
            }
        }
    }
}
