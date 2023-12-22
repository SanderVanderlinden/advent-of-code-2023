package com.sandervanderlinden.adventofcode2023.day12;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 12 in the Advent of Code 2023.
 */
public class Day12Puzzle01Solver extends Day12PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day12Puzzle01Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day12Puzzle01Solver solver = new Day12Puzzle01Solver();
        String filePath = "day12/day12_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }
}