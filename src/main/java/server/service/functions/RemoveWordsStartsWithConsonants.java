package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.parser.RegexProvider;
import server.service.TextElementUtil;

import java.util.ArrayList;
import java.util.List;

public class RemoveWordsStartsWithConsonants {
    public TextElement getText(TextElement text, int length) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Sentence> sentences = textElementUtil.getAllSentences(text);
        for(Sentence sentence: sentences){
            sentence.setSentence(getNewSentence(sentence,length).getSentence());
        }
        return text;
    }

    private Sentence getNewSentence(Sentence sentence,int length) {
        Sentence newSentence= new Sentence();
        List<TextElement> elements = new ArrayList<>();
        for(TextElement element : sentence.getSentence()){
            if(element instanceof Word){
                if(element.value().length()==length && !element.value().matches(RegexProvider.getInstance().get("firstLettersVowelRegEx"))){
                    break;
                }
            }
            elements.add(element);
        }
        newSentence.setSentence(elements);
        return newSentence;
    }
}
