package com.sandervanderlinden.adventofcode2023.day03.schematic;

public abstract class SchematicToken {
    int positionIndex;

    protected SchematicToken(int positionIndex) {
        this.positionIndex = positionIndex;
    }

    public int getPositionIndex() {
        return this.positionIndex;
    }
}
