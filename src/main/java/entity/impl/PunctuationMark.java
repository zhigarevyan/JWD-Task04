package entity.impl;

import entity.TextElement;

import java.util.Objects;

public class PunctuationMark implements TextElement {
    private String punctuationMark;

    public PunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String value() {
        return punctuationMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return getPunctuationMark().equals(that.getPunctuationMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPunctuationMark());
    }
}
