package com.sandervanderlinden.adventofcode2023.day03.schematic;

import java.util.Objects;
import java.util.Set;

public class Number extends SchematicToken {

    private int value;
    private boolean alreadyCounted;

    public Number(int positionIndex, int value) {
        super(positionIndex);
        setValue(value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAlreadyCounted() {
        return alreadyCounted;
    }

    public void setAlreadyCounted(boolean alreadyCounted) {
        this.alreadyCounted = alreadyCounted;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Number number)) return false;
        return positionIndex == number.positionIndex && value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionIndex, value);
    }

    @Override
    public String toString() {
        return "Number{positionIndex=" + getPositionIndex() + ", value=" + value + "}";
    }

    public boolean isAdjacentToSymbolInSameLine(Set<SchematicToken> tokensInCurrentLine) {
        return tokensInCurrentLine.stream()
                .filter(Symbol.class::isInstance)
                .anyMatch(token -> token.positionIndex == this.positionIndex - 1 || token.positionIndex == this.positionIndex + this.getLength());
    }

    private int getLength() {
        return String.valueOf(this.value).length();
    }


    public boolean isAdjacentToSymbolInOtherLine(Set<SchematicToken> tokensInPreviousLine) {
        return tokensInPreviousLine.stream()
                .filter(Symbol.class::isInstance)
                .anyMatch(token -> token.positionIndex >= this.positionIndex - 1  && this.positionIndex <= token.positionIndex + this.getLength());
    }

}
