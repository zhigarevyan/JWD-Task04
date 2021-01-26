package server.dao.impl;

import entity.TextElement;
import server.dao.TextDAO;
import server.dao.TextFileReader;
import server.parser.ParserProvider;
import server.parser.impl.BookParser;

public class TextDAOImpl implements TextDAO{
    private final BookParser bookParser;
    private static final String filePath = "src/main/resources/myFile.txt";

    public TextDAOImpl() {
        bookParser = ParserProvider.getBookParser();
    }

    @Override
    public TextElement getText() {
        TextFileReader textFileReader = new TextFileReader(filePath);
        return bookParser.parse(textFileReader.readAll());
    }
}
