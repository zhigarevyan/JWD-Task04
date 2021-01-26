package server.parser;

import entity.TextElement;

public interface Parser {
    TextElement parse(String textToParse);
}
