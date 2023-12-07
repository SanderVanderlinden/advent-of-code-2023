package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import com.sandervanderlinden.adventofcode2023.util.DigitExtractionUtility;

import java.util.logging.Logger;

/**
 * Concrete implementation of Day01PuzzleSolver for the first puzzle of Day 1.
 * This class specializes in extracting digits from textual representations and processing them.
 */
public class Day01Puzzle01Solver extends Day01PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day01Puzzle01Solver.class.getName());

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day01PuzzleSolver solver = new Day01Puzzle01Solver();
        Object result = solver.solve("day01/day01_input.txt");
        checkResult(result, logger);
    }

    @Override
    public int extractFirstDigit(String line) throws NoDigitFoundException {
        return DigitExtractionUtility.extractFirstDigit(line);
    }

    @Override
    public int extractLastDigit(String line) {
        return DigitExtractionUtility.extractLastDigit(line);
    }


}
