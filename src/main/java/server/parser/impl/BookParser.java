package server.parser.impl;

import server.dao.TextFileReader;
import entity.TextElement;
import entity.impl.Code;
import entity.impl.PunctuationMark;
import entity.impl.Text;
import server.parser.Parser;
import server.parser.ParserProvider;
import server.parser.RegexProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser implements Parser {
    private final Pattern partOfTextPattern;

    public BookParser() {
        partOfTextPattern = Pattern.compile(RegexProvider.getInstance().get("partRegEx"));
    }

    @Override
    public TextElement parse(String textToParse) {
        TextBlockParser textBlockParser = ParserProvider.getTextBlockParser();
        Matcher partOfTextMatcher = partOfTextPattern.matcher(textToParse);
        Text text = new Text();

        while (partOfTextMatcher.find()) {
            String stringTextBlock = partOfTextMatcher.group("TextBlock");
            String stringCodeBlock = partOfTextMatcher.group("CodeBlock");

            if (stringTextBlock != null) {
                TextElement textBlock = textBlockParser.parse(stringTextBlock);
                text.add(textBlock);
            }
            if (stringCodeBlock != null) {
                TextElement codeBlock = new Code(stringCodeBlock);
                text.add(codeBlock);
            }
            text.add(new PunctuationMark("\n"));
        }
        return text;
    }


    public static void main(String[] args) {
        TextFileReader textFileReader = new TextFileReader("src/main/resources/myFile.txt");
        BookParser bookParser = ParserProvider.getBookParser();
        String text = textFileReader.readAll();
        TextElement element = bookParser.parse(text);
        System.out.println(element.value());

    }
}

