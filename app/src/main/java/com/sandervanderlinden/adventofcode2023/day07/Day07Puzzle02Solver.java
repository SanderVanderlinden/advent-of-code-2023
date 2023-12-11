package com.sandervanderlinden.adventofcode2023.day07;


import com.sandervanderlinden.adventofcode2023.day07.cards.Puzzle02Hand;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;
import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.spaceSeparatedStringToList;

/**
 * This class solves the first puzzle of Day 7 in the Advent of Code 2023.
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
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }

    @Override
    public void processLine(String line) {
        var lineContents = spaceSeparatedStringToList(line);
        hands.add(new Puzzle02Hand(lineContents.get(0), Integer.parseInt(lineContents.get(1))));
    }

}