package com.sandervanderlinden.adventofcode2023.day05;


import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceInterval;

import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;
import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractNumbersAsLongStream;

/**
 * This class solves the first puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic destination process lines of input
 * and calculate a final output based on the puzzle's rules.
 */
public class Day05Puzzle02Solver extends Day05PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day05Puzzle02Solver.class.getName());


    /**
     * The main method that initializes the solver, processes the input file,
     * and logs the total sum calculated by the solver.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day05Puzzle02Solver solver = new Day05Puzzle02Solver();
        String filePath = "day05/day05_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    void initializeResourceState(String line) {
        LinkedList<Long> lineNumbers = extractNumbersAsLongStream(line)
                .collect(Collectors.toCollection(LinkedList::new));
        while (!lineNumbers.isEmpty()) {
            currentResourceState.addInterval(new ResourceInterval(lineNumbers.poll(), lineNumbers.poll()));
        }

    }

}