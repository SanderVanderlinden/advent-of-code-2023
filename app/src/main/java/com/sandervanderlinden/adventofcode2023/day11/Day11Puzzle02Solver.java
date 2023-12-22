package com.sandervanderlinden.adventofcode2023.day11;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the first puzzle of Day 11 in the Advent of Code 2023.
 */
public class Day11Puzzle02Solver extends Day11PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day11Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day11Puzzle02Solver solver = new Day11Puzzle02Solver();
        String filePath = "day11/day11_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }


    @Override
    public void initializeSolver(){
        setExpansionFactor(999999);
    }
}