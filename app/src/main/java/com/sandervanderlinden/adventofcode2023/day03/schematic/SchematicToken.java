package com.sandervanderlinden.adventofcode2023.day03.schematic;

/**
 * Abstract base class for different types of tokens in the schematic puzzle.
 * This class provides a common structure for tokens, including their position in the schematic.
 */
public abstract class SchematicToken {

    int positionIndex;

    protected SchematicToken(int positionIndex) {
        this.positionIndex = positionIndex;
    }

    public int getPositionIndex() {
        return this.positionIndex;
    }

}
