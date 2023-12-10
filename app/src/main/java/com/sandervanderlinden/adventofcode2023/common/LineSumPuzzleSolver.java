package com.sandervanderlinden.adventofcode2023.common;

public abstract class LineSumPuzzleSolver implements BasePuzzleSolver {

    protected int sum;

    @Override
    public void initializeSolver() {
        sum = 0;
    }

    @Override
    public void processLine(String line) {
        int value = extractValueFromLine(line);
        sum += value;
    }

    @Override
    public Object finalizeSolver() {
        return sum;
    }

    /**
     * Extracts a value from a given line of text.
     * This method must be implemented by subclasses destination define how values are extracted.
     *
     * @param line The line of text from which destination extract the value.
     * @return The extracted value as an integer.
     */
    protected abstract int extractValueFromLine(String line);
}
