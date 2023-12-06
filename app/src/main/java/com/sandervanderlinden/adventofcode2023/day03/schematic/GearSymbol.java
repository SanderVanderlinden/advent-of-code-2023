package com.sandervanderlinden.adventofcode2023.day03.schematic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a gear symbol in the schematic puzzle, characterized by its position and associated numbers.
 * This class extends the Symbol class to include specific functionalities related to gears,
 * such as calculating gear ratios and determining if a symbol qualifies as a gear.
 */
public class GearSymbol extends Symbol {

    private final Set<Number> partNumbers;

    /**
     * Constructs a GearSymbol with a specified position in the schematic.
     * It initializes the set of part numbers associated with this gear.
     *
     * @param positionIndex the index position of this GearSymbol in the schematic
     */
    public GearSymbol(int positionIndex) {
        super(positionIndex);
        this.partNumbers = new HashSet<>();
    }

    /**
     * Adds a number to the gear symbol's part numbers. Part numbers are numbers that are adjacent to or part of the gear.
     *
     * @param number The number to be added to the gear symbol's parts.
     */
    protected void addToPartNumbers(Number number) {
        partNumbers.add(number);
    }


    /**
     * Determines if this symbol represents a gear based on its associated part numbers.
     *
     * @return true if the symbol represents a gear, false otherwise.
     */
    public boolean isGear() {
        return partNumbers.size() == 2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GearSymbol)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return "GearSymbol{" +
                "partNumbers=" + partNumbers +
                ", positionIndex=" + positionIndex +
                '}';
    }

    /**
     * Calculates the gear ratio, which is a product of the values of the part numbers associated with this gear.
     *
     * @return The gear ratio as an integer.
     */
    public int getRatio() {
        return partNumbers.stream()
                .mapToInt(Number::getValue)
                .reduce(1, (a, b) -> a * b);
    }
}
