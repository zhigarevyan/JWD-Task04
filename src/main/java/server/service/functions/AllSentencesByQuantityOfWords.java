package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import server.service.TextElementUtil;
import java.util.Comparator;
import java.util.List;

public class AllSentencesByQuantityOfWords {

    private final Comparator<Sentence> sentenceSizeComparator = Comparator.comparingInt(s -> s.getSentence().size());


    public List<Sentence> getSentences(TextElement text) {
        TextElementUtil textElementUtil = new TextElementUtil();
        List<Sentence> sentences = textElementUtil.getAllSentences(text);
        sentences.sort(sentenceSizeComparator);
        return sentences;
    }

/*    public static void main(String[] args) {
        TextServiceImpl textService  = new TextServiceImpl();
        new AllSentencesByQuantityOfWords().getSentences(textService.getText());
    }*/
}
