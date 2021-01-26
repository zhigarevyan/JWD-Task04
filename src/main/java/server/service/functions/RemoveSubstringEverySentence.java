package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import server.parser.ParserProvider;
import server.service.TextElementUtil;

import java.util.List;



public class RemoveSubstringEverySentence {
    public TextElement getText(TextElement text, char startChar, char endChar) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Sentence>  sentences = textElementUtil.getAllSentences(text);
        for(Sentence sentence: sentences){
            sentence.setSentence(getSentenceWithRemovedSubstring(sentence,Character.toLowerCase(startChar),Character.toLowerCase(endChar)).getSentence());
        }
        return text;
    }

    private Sentence getSentenceWithRemovedSubstring(Sentence sentence, char startChar, char endChar) {
        String stringSentence = sentence.value().replaceFirst("["+startChar+Character.toUpperCase(startChar)+"].*["+endChar+Character.toUpperCase(endChar)+"]","");
        return (Sentence)ParserProvider.getSentenceParser().parse(stringSentence);
    }


}
