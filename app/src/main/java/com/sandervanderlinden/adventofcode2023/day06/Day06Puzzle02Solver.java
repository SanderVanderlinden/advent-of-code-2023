package com.sandervanderlinden.adventofcode2023.day06;


import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility.extractNumbersAsOneNumber;

/**
 * This class solves the first puzzle of Day 6 in the Advent of Code 2023.
 */
public class Day06Puzzle02Solver extends Day06PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day06Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day06Puzzle02Solver solver = new Day06Puzzle02Solver();
        Object result = solver.solve("day06/day06_input.txt");
        logResult(result, Long.class, logger);
    }

    @Override
    public void processLine(String line) {
        if (line.startsWith("Time:")) {
            times.add(extractNumbersAsOneNumber(line));
        }
        else if (line.startsWith("Distance:")) {
            distances.add(extractNumbersAsOneNumber(line));
        }
    }

}