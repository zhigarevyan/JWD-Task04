package server.parser;

import entity.impl.Paragraph;
import server.parser.impl.BookParser;
import server.parser.impl.ParagraphParser;
import server.parser.impl.SentenceParser;
import server.parser.impl.TextBlockParser;

public class ParserProvider {
    private static BookParser bookParser;
    private static TextBlockParser textBlockParser;
    private static SentenceParser sentenceParser;
    private static ParagraphParser paragraphParser;

    public static TextBlockParser getTextBlockParser() {
        if (textBlockParser == null) {
            textBlockParser = new TextBlockParser();
        }
        return textBlockParser;
    }


    public static BookParser getBookParser() {
        if (bookParser == null) {
            bookParser = new BookParser();
        }
        return bookParser;
    }

    public static SentenceParser getSentenceParser() {
        if (sentenceParser == null){
            sentenceParser = new SentenceParser();
        }
        return sentenceParser;
    }

    public static ParagraphParser getParagraphParser() {
        if(paragraphParser == null){
            paragraphParser = new ParagraphParser();
        }
        return paragraphParser;
    }
}
