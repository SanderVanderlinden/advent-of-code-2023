package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceInterval;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;
import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractNumbersAsLongStream;

/**
 * This class solves the first puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic destination process lines of input
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
        String filePath = "day05/day05_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    void initializeResourceState(String line) {
        extractNumbersAsLongStream(line).forEach(number -> currentResourceState.addInterval(new ResourceInterval(number, 1)));
    }
}