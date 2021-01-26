package entity.impl;

import entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph implements TextElement {

    private List<TextElement> paragraph = new ArrayList<>();

    public void add(TextElement textElement){
        paragraph.add(textElement);
    }

    public List<TextElement> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<TextElement> paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();
        for(TextElement textElement : paragraph){
            builder.append(textElement.value());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph1 = (Paragraph) o;
        return getParagraph().equals(paragraph1.getParagraph());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParagraph());
    }
}
