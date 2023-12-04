package com.sandervanderlinden.adventofcode2023.day03;


import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solver for Day 3 Puzzle 1 of Advent of Code 2023.
 */
public class Day03Puzzle01Solver {

    private static final Logger logger = Logger.getLogger(Day03Puzzle01Solver.class.getName());

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day03Puzzle01Solver solver = new Day03Puzzle01Solver();
        int sum = solver.solve();
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    int solve() {
        return FileReaderUtil.processFile("/day03/day03_input.txt", this::solveLine);
    }

    private int solveLine(String line) {
        return 0;
    }


}
