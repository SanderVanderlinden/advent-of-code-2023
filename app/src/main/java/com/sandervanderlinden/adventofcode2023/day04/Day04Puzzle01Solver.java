package com.sandervanderlinden.adventofcode2023.day04;


import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Solver for Day 4 Puzzle 1 of Advent of Code 2023.
 */
public class Day04Puzzle01Solver extends Day04PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day04Puzzle01Solver.class.getName());


    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day04Puzzle01Solver solver = new Day04Puzzle01Solver();
        int sum = solver.solve("day04/day04_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    @Override
    public int processLine(String line) {
        int output = 0;
        String numberPartOfLine = line.substring(line.indexOf(":") + 1).trim();

        String[] numbers = numberPartOfLine.split("[|]");

        Set<Integer> winningNumbers = Arrays.stream(numbers[0].split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Set<Integer> ownNumbers = Arrays.stream(numbers[1].split("\\s+"))
                .filter(number -> !number.equals(""))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        for (Integer number : winningNumbers) {
            if (ownNumbers.contains(number)) {
                output = output == 0 ? 1 : output * 2;
            }
        }
        return output;
    }

}
