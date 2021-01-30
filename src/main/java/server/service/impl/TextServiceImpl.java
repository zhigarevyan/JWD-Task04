package server.service.impl;

import entity.TextElement;
import entity.impl.Digit;
import entity.impl.Sentence;
import entity.impl.Text;
import entity.impl.Word;
import server.dao.TextDAO;
import server.dao.TextDAOProvider;
import server.service.TextService;
import server.service.exception.ServiceException;
import server.service.functions.*;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {
    private final TextDAO textDAO;

    public TextServiceImpl() {
        textDAO = TextDAOProvider.getTextDAO();
    }

    @Override
    public TextElement getText() {
        return textDAO.getText();
    }

    @Override
    public TextElement getMaxCountOfSentencesWithRepeatedWord() throws ServiceException {
        Text text = new Text();
        int digit = new MaxCountOfSentencesWithRepeatedWord().getCount(getText());
        text.add(new Digit(String.valueOf(digit)));
        return text;
    }

    @Override
    public TextElement getAllSentencesByQuantityOfWords() throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new AllSentencesByQuantityOfWords().getSentences(getText()));
        return getTextElement(elements);
    }

    @Override
    public Word getWordInFirstSentenceThatNotExistInOthers() throws ServiceException {
        return new WordInFirstSentenceThatNotExistInOthers().getWord(getText());
    }

    @Override
    public TextElement getUniqueWordsFromQuestions(int length) throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new UniqueWordFromQuestions().getWords(getText(),length));
        return getTextElement(elements);
    }

    @Override
    public TextElement swapFirstAndLastWordEverySentence() throws ServiceException {
        return new SwapFirstAndLastWordEverySentence().swap(getText());
    }

    @Override
    public TextElement getListOfWordsByAlphabet() throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsByAlphabet().getList(getText()));
        return getTextElement(elements);
    }

    @Override
    public TextElement getListOfWordsSortedByVowelPercentage() throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsByVowelPercentage().getList(getText()));
        return getTextElement(elements);
    }

    @Override
    public TextElement getListOfWordsThatBeginsWithVowel() throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsThatBeginsWithVowel().getList(getText()));
        return getTextElement(elements);
    }

    @Override
    public TextElement getListOfWordsSortedByCountOfLetterAsc(char letter) throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsSortedByCountOfLetterAsc().getList(getText(),letter));
        return getTextElement(elements);
    }

    @Override
    public TextElement getListOfWordsSortedByCountOfLetterDesc(char letter) throws ServiceException {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsSortedByCountOfLetterDesc().getList(getText(),letter));
        return getTextElement(elements);
    }

    @Override
    public TextElement removeStartLettersFromWords() throws ServiceException {
        return new RemoveStartLettersFromWords().getText(getText());
    }

    @Override
    public TextElement replaceWordsToSubString(int length, String subString) throws ServiceException {
        return new ReplaceWordsToSubString().getText(getText(),length,subString);
    }

    @Override
    public TextElement getListOfWordsSortedByCountOfSentences(List<Word> words) {
        List<TextElement> elements = new ArrayList<>(new ListOfWordsSortedByCountOfSentences().getList(getText(),words));
        return getTextElement(elements);
    }

    @Override
    public TextElement removeSubstringEverySentence(char startChar, char endChar) throws ServiceException {
        return  new RemoveSubstringEverySentence().getText(getText(),startChar,endChar);

    }

    @Override
    public TextElement removeWordsStartsWithConsonants(int length) throws ServiceException {
        return new RemoveWordsStartsWithConsonants().getText(getText(),length);
    }

    private TextElement getTextElement(List<TextElement> elementList){
        Text text = new Text();
        List<TextElement> elements = new ArrayList<>(elementList);
        text.setTextElements(elements);
        return text;
    }


    /*public static void main(String[] args) {
        TextServiceImpl textService = new TextServiceImpl();
        TextElement textElement = textService.getText();
        TextElement text = textService.replaceWordsToSubString(4,"jopa");
                //.removeStartLettersFromWords();
        System.out.println(text.value());
        //List<Word> words1 =textService.getListOfWordsSortedByCountOfLetterDesc('o');
        //List<Word> words2 =textService.getListOfWordsSortedByCountOfLetterAsc('o');
                //removeWordsStartsWithConsonants(7);
                //removeSubstringEverySentence('e','t');
                //getListOfWordsSortedByCountOfSentences(new TextElementUtil().getUniqueWords(textElement));
                //getListOfWordsSortedByCountOfLetter('o');
                //textService.getListOfWordsThatBeginsWithVowel();
        //List<Word> words = textService.getListOfWordsByAlphabet();
        //System.out.println(words1+"\n");
        //System.out.println(words2+"\n");

    }*/

}
