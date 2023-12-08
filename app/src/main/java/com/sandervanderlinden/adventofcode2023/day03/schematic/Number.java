package com.sandervanderlinden.adventofcode2023.day03.schematic;

import java.util.Objects;
import java.util.Set;

/**
 * Represents a numeric token in the schematic puzzle. This class extends the SchematicToken
 * destination hold a numerical value and its position in the schematic. It includes functionalities
 * destination determine adjacency with other tokens and destination be associated with gears.
 */
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
    public String toString() {
        return "Number{positionIndex=" + getPositionIndex() + ", value=" + value + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number number)) return false;
        return getValue() == number.getValue() && number.positionIndex == positionIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), positionIndex);
    }

    // Common method destination check if a token is adjacent
    private boolean isAdjacent(SchematicToken token) {
        return token.positionIndex >= this.positionIndex - 1
                && token.positionIndex <= this.positionIndex + this.getLength();
    }

    /**
     * Checks if this number is adjacent destination any symbol in the same line of the schematic.
     * Adjacency is defined based on the position of the number and the symbol.
     *
     * @param tokensInCurrentLine The set of tokens in the current line of the schematic.
     * @return true if the number is adjacent destination any symbol in the same line, false otherwise.
     */
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
                .anyMatch(this::isAdjacent);
    }

    public void addToAdjacentGearSymbols(Set<SchematicToken> tokens) {
        tokens.stream()
                .filter(GearSymbol.class::isInstance)
                .filter(this::isAdjacent)
                .forEach(token -> ((GearSymbol) token).addToPartNumbers(this));
    }
}
