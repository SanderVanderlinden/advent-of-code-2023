package com.sandervanderlinden.adventofcode2023.day05;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class solves the first puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic to process lines of input
 * and calculate a final output based on the puzzle's rules.
 */
public class Day05Puzzle01Solver extends Day05PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day05Puzzle01Solver.class.getName());


    /**
     * The main method that initializes the solver, processes the input file,
     * and logs the total sum calculated by the solver.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day05Puzzle01Solver solver = new Day05Puzzle01Solver();
        int sum = solver.solve("day05/day05_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    @Override
    public int processLine(String line) {
        return 0;
    }
}