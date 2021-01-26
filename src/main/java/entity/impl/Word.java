package entity.impl;

import entity.TextElement;

import java.util.Objects;

public class Word implements TextElement {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String value() {
        return word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return getWord().equals(word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }
}
