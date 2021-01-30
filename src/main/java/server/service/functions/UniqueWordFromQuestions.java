package server.service.functions;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.TextElementUtil;
import server.service.exception.ServiceException;

import java.util.*;

public class UniqueWordFromQuestions {
    private final TextElementUtil textElementUtil = new TextElementUtil();


    public List<Word> getWords(TextElement text, int length) throws ServiceException {
        List<Sentence> questionSentences = textElementUtil.getAllQuestionSentences(text);
        List<Word> wordsFromSentences = getListOfUniqueWordsFromListOfSentences(questionSentences);
        List<Word> resultList = new ArrayList<>();
        for (Word word : wordsFromSentences) {
            if (length == word.value().length()) {
                resultList.add(word);
            }
        }
        return resultList;
    }

    private List<Word> getListOfUniqueWordsFromListOfSentences(List<Sentence> sentences) throws ServiceException {
        Set<Word> wordsFromSentences = new HashSet<>();
        for (Sentence sentence : sentences) {
            wordsFromSentences.addAll(textElementUtil.getAllWordsFromSentence(sentence));
        }
        return new ArrayList<>(wordsFromSentences);
    }


/*    public static void main(String[] args) {
        System.out.println(new UniqueWordFromQuestions().getWords(new TextServiceImpl().getText(),4));
    }*/
}
