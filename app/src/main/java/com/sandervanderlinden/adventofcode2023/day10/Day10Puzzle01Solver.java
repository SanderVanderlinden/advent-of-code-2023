package com.sandervanderlinden.adventofcode2023.day10;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 10 in the Advent of Code 2023.
 */
public class Day10Puzzle01Solver extends Day10PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day10Puzzle01Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day10Puzzle01Solver solver = new Day10Puzzle01Solver();
        String filePath = "day10/day10_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    Object solution() {
        return  loopLength / 2;
    }
}