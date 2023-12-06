package com.sandervanderlinden.adventofcode2023.day03.schematic;

import java.util.Objects;

/**
 * Represents a basic symbol in the schematic puzzle. This class provides the foundational
 * representation for different types of symbols, identified by their position in the schematic.
 */
public class Symbol extends SchematicToken {

    /**
     * Constructs a Symbol with a specified position in the schematic.
     *
     * @param positionIndex the index position of this Symbol in the schematic
     */
    public Symbol(int positionIndex) {
        super(positionIndex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Symbol symbol)) return false;
        return positionIndex == symbol.positionIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionIndex);
    }
}

