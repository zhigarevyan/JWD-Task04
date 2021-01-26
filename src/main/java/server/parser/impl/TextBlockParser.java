package server.parser.impl;

import entity.TextElement;
import entity.impl.PunctuationMark;
import entity.impl.Text;
import server.parser.Parser;
import server.parser.ParserProvider;
import server.parser.RegexProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlockParser implements Parser {
    private final Pattern paragraphPattern;

    public TextBlockParser() {
        paragraphPattern = Pattern.compile(RegexProvider.getInstance().get("paragraphRegEx"));
    }

    @Override
    public TextElement parse(String textToParse) {
        Text textBlock = new Text();
        ParagraphParser paragraphParser = ParserProvider.getParagraphParser();
        Matcher paragraphMatcher = paragraphPattern.matcher(textToParse);

        while (paragraphMatcher.find()) {
            String stringParagraph = paragraphMatcher.group();
            if (stringParagraph != null) {
                TextElement paragraph = paragraphParser.parse(stringParagraph);
                textBlock.add(paragraph);
            }
            textBlock.add(new PunctuationMark("\n"));
        }
        return textBlock;
    }
}
