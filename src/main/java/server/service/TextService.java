package server.service;

import entity.TextElement;
import entity.impl.Sentence;
import entity.impl.Word;

import java.util.List;

public interface TextService {
    TextElement getText();
    TextElement getMaxCountOfSentencesWithRepeatedWord();
    TextElement getAllSentencesByQuantityOfWords();
    TextElement getWordInFirstSentenceThatNotExistInOthers();
    TextElement getUniqueWordsFromQuestions(int length);
    TextElement swapFirstAndLastWordEverySentence();
    TextElement getListOfWordsByAlphabet();
    TextElement getListOfWordsSortedByVowelPercentage();
    TextElement getListOfWordsThatBeginsWithVowel();
    TextElement getListOfWordsSortedByCountOfLetterAsc(char letter);
    TextElement getListOfWordsSortedByCountOfSentences(List<Word> words);
    TextElement removeSubstringEverySentence(char startChar,char endChar);
    TextElement removeWordsStartsWithConsonants(int length);
    TextElement getListOfWordsSortedByCountOfLetterDesc(char letter);
    TextElement removeStartLettersFromWords();
    TextElement replaceWordsToSubString(int length,String subString);
}
