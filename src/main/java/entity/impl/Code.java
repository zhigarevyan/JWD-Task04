package entity.impl;

import entity.TextElement;

import java.util.Objects;

public class Code implements TextElement {
    private String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String value() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return getCode().equals(code1.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
}
