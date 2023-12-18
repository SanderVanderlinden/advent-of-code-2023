package com.sandervanderlinden.adventofcode2023.day09;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;
import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractNumbersAsList;

/**
 * This class solves the second puzzle of Day 09 in the Advent of Code 2023.
 */
public class Day09Puzzle02Solver extends Day09PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day09Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day09Puzzle02Solver solver = new Day09Puzzle02Solver();
        String filePath = "day09/day09_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    protected long extractValueFromLine(String line) {
        return calculateValue(extractNumbersAsList(line).reversed());
    }


}