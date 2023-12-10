package com.sandervanderlinden.adventofcode2023.day04;


import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic to process lines of input
 * and calculate a final output based on the puzzle's rules.
 */
public class Day04Puzzle01Solver extends Day04PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day04Puzzle01Solver.class.getName());


    /**
     * The main method that initializes the solver, processes the input file,
     * and logs the total sum calculated by the solver.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day04PuzzleSolver solver = new Day04Puzzle01Solver();
        String filePath = "day04/day04_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);    }

    /**
     * Processes a single line of the input file and calculates a value based on the puzzle logic.
     * This method splits the line into winning numbers and own numbers, then checks for overlaps
     * to calculate the final output value.
     *
     * @param line A single line from the input file.
     * @return The calculated value based on the line's data.
     */
    @Override
    public int extractValueFromLine(String line) {
        int amountOfMatchingNumbers = getAmountOfMatchingNumbers(line);
        return (int) Math.pow(2, amountOfMatchingNumbers - 1.0);
    }

}