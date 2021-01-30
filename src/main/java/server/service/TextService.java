package server.service;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;
import server.service.exception.ServiceException;

import java.util.List;

public interface TextService {
    TextElement getText();
    TextElement getMaxCountOfSentencesWithRepeatedWord() throws ServiceException;
    TextElement getAllSentencesByQuantityOfWords() throws ServiceException;
    TextElement getWordInFirstSentenceThatNotExistInOthers() throws ServiceException;
    TextElement getUniqueWordsFromQuestions(int length) throws ServiceException;
    TextElement swapFirstAndLastWordEverySentence() throws ServiceException;
    TextElement getListOfWordsByAlphabet() throws ServiceException;
    TextElement getListOfWordsSortedByVowelPercentage() throws ServiceException;
    TextElement getListOfWordsThatBeginsWithVowel() throws ServiceException;
    TextElement getListOfWordsSortedByCountOfLetterAsc(char letter) throws ServiceException;
    TextElement getListOfWordsSortedByCountOfSentences(List<Word> words);
    TextElement removeSubstringEverySentence(char startChar,char endChar) throws ServiceException;
    TextElement removeWordsStartsWithConsonants(int length) throws ServiceException;
    TextElement getListOfWordsSortedByCountOfLetterDesc(char letter) throws ServiceException;
    TextElement removeStartLettersFromWords() throws ServiceException;
    TextElement replaceWordsToSubString(int length,String subString) throws ServiceException;
}
