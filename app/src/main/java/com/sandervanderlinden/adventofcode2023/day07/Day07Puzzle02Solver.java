package com.sandervanderlinden.adventofcode2023.day07;


import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 6 in the Advent of Code 2023.
 */
public class Day07Puzzle02Solver extends Day07PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day07Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day07Puzzle02Solver solver = new Day07Puzzle02Solver();
        String filePath = "day07/day07_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    public void processLine(String line) {

    }

    @Override
    public Object finalizeSolver() {
        return null;
    }
}