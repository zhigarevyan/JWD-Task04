package server.service;

import entity.TextElement;
import entity.impl.*;
import server.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class TextElementUtil {
    public List<Word> getAllWords(TextElement text) throws ServiceException {
        if(!(text instanceof Text)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Sentence> sentences = getAllSentences(text);
        List<Word> words = new ArrayList<>();

        for(Sentence sentence : sentences){
            for(TextElement element : sentence.getSentence()){
                if(element instanceof Word){
                    words.add((Word)element);
                }
            }
        }
        return words;
    }

    public List<Word> getUniqueWords(TextElement text) throws ServiceException {
        if(!(text instanceof Text)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Word> allWords = getAllWords(text);
        List<Word> uniqueWords = new ArrayList<>();
        List<String> stringWords = new ArrayList<>();

        for (Word word : allWords){
            if(!stringWords.contains(word.value().toLowerCase())){
                stringWords.add(word.value().toLowerCase());
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    public List<Word> getAllWordsFromSentence(TextElement sentence) throws ServiceException {
        if(!(sentence instanceof Sentence)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Word> words = new ArrayList<>();
        for(TextElement element : ((Sentence)sentence).getSentence()){
            if(element instanceof Word){
                words.add((Word)element);
            }
        }
        return words;
    }

    public List<Sentence> getAllSentences(TextElement text) throws ServiceException {
        if(!(text instanceof Text)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Paragraph> paragraphs = getAllTextParagraphs(text);
        List<Sentence> sentences = new ArrayList<>();

        for(Paragraph paragraph : paragraphs){
            for(TextElement element : paragraph.getParagraph()){
                if(element instanceof Sentence){
                    sentences.add((Sentence) element);
                }
            }
        }
        return sentences;
    }

    public List<Paragraph> getAllTextParagraphs(TextElement text) throws ServiceException {
        if(!(text instanceof Text)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Paragraph> paragraphs = new ArrayList<>();
        for(TextElement textPart :((Text)text).getTextElements()){
            if(textPart instanceof Text) {
                for (TextElement element : ((Text) textPart).getTextElements()) {
                    if (element instanceof Paragraph) {
                        paragraphs.add((Paragraph) element);
                    }
                }
            }
        }
        return paragraphs;
    }

    public boolean isWordInSentence(TextElement sentence, TextElement wordToCheck) throws ServiceException {
        if(!(sentence instanceof Sentence || !(wordToCheck instanceof Word))){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        for(TextElement word : getAllWordsFromSentence((sentence))){
            if(word.value().toLowerCase().equals(wordToCheck.value().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public List<Sentence> getAllQuestionSentences(TextElement text) throws ServiceException {
        if(!(text instanceof Text)){
            throw new ServiceException("Wrong class at TextElementUtil");
        }
        List<Sentence> allSentences = getAllSentences(text);
        List<Sentence> questionSentences = new ArrayList<>();
        for(Sentence sentence : allSentences){
            for(TextElement element : sentence.getSentence()){
                if(element instanceof PunctuationMark && element.value().equals("?")){
                    questionSentences.add(sentence);
                }
            }
        }
        return questionSentences;
    }

/*
    public static void main(String[] args) {
        System.out.println(new TextElementUtil().getAllQuestionSentenses(new TextServiceImpl().getText()));
    }
*/

}
