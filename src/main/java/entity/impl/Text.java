package entity.impl;

import entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements TextElement {

    private List<TextElement> textElements = new ArrayList<>();

    public void add(TextElement textElement){
        textElements.add(textElement);
    }

    public List<TextElement> getTextElements() {
        return textElements;
    }

    public void setTextElements(List<TextElement> textElements) {
        this.textElements = textElements;
    }

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();
        for(TextElement textElement : textElements){
            builder.append(textElement.value()).append(" ");
        }
        return builder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return getTextElements().equals(text.getTextElements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTextElements());
    }
}
