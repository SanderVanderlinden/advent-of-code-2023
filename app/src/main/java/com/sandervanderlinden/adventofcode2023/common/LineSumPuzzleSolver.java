package com.sandervanderlinden.adventofcode2023.common;

import java.util.logging.Logger;

public abstract class LineSumPuzzleSolver implements BasePuzzleSolver {

    protected int sum;

    protected static void checkResult(Object result, Logger logger) {
        if (result instanceof Integer sum) {
            String message = String.format("Total sum: %d", sum);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result;
            logger.warning(message);
        }
    }

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
