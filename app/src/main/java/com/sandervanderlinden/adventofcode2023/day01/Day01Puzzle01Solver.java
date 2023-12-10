package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

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
        Day01Puzzle01Solver solver = new Day01Puzzle01Solver();
        String filePath = "day01/day01_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }

    @Override
    public int extractFirstDigit(String line) throws NoDigitFoundException {
        return NumberExtractionUtility.extractFirstDigit(line);
    }

    @Override
    public int extractLastDigit(String line) {
        return NumberExtractionUtility.extractLastDigit(line);
    }
}
