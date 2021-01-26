package server.parser.impl;

import entity.TextElement;
import entity.impl.Paragraph;
import server.parser.Parser;
import server.parser.ParserProvider;
import server.parser.RegexProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser {
    private final Pattern sentencePattern;

    public ParagraphParser() {
        sentencePattern = Pattern.compile(RegexProvider.getInstance().get("sentenceRegEx"));
    }

    @Override
    public TextElement parse(String textToParse) {
        Paragraph paragraph = new Paragraph();
        SentenceParser sentenceParser = ParserProvider.getSentenceParser();
        Matcher sentenceMatcher = sentencePattern.matcher(textToParse);
        while(sentenceMatcher.find()){
            String stringSentence = sentenceMatcher.group();
            if(stringSentence !=null){
                TextElement sentence = sentenceParser.parse(stringSentence);
                paragraph.add(sentence);
            }
            //paragraph.add(new PunctuationMark("\n"));
        }
        return paragraph;
    }
}
