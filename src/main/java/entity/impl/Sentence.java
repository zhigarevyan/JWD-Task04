package entity.impl;

import entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements TextElement {

    private List<TextElement> sentence = new ArrayList<>();

    public void add(TextElement textElement){
        sentence.add(textElement);
    }

    public List<TextElement> getSentence() {
        return sentence;
    }

    public void setSentence(List<TextElement> sentence) {
        this.sentence = sentence;
    }

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();
        for(TextElement textElement : sentence){
            builder.append(textElement.value()).append(" ");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return getSentence().equals(sentence1.getSentence());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSentence());
    }
}
