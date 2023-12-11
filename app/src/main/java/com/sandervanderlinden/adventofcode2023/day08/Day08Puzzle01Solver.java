package com.sandervanderlinden.adventofcode2023.day08;


import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 8 in the Advent of Code 2023.
 */
public class Day08Puzzle01Solver extends Day08PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day08Puzzle01Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day08Puzzle01Solver solver = new Day08Puzzle01Solver();
        String filePath = "day08/day08_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }
}