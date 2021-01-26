package entity.impl;

import entity.TextElement;

import java.util.Objects;

public class Digit implements TextElement {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return getDigit().equals(digit1.getDigit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDigit());
    }

    private String digit;

    public Digit(String digit) {
        this.digit = digit;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    @Override
    public String value() {
        return digit;
    }
}
