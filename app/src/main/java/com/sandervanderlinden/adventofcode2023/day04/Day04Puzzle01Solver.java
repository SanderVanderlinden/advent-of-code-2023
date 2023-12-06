package com.sandervanderlinden.adventofcode2023.day04;


import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
        Day04Puzzle01Solver solver = new Day04Puzzle01Solver();
        int sum = solver.solve("day04/day04_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    /**
     * Processes a single line of the input file and calculates a value based on the puzzle logic.
     * This method splits the line into winning numbers and own numbers, then checks for overlaps
     * to calculate the final output value.
     *
     * @param line A single line from the input file.
     * @return The calculated value based on the line's data.
     */
    @Override
    public int processLine(String line) {
        int output = 0;
        String[] numberGroups = parseLine(line);

        Set<Integer> winningNumbers = parseNumbers(numberGroups[0]);
        Set<Integer> ownNumbers = parseNumbers(numberGroups[1]);

        for (Integer number : winningNumbers) {
            if (ownNumbers.contains(number)) {
                output = output == 0 ? 1 : output * 2;
            }
        }
        return output;
    }

    /**
     * Parses a line from the input file to extract the winning and own numbers.
     * The method assumes the line is formatted with a colon and a pipe symbol separating the numbers.
     *
     * @param line A single line from the input file.
     * @return An array of two strings, where the first element is the string of winning numbers
     *         and the second is the string of own numbers.
     */
    private String[] parseLine(String line) {
        return line.substring(line.indexOf(":") + 1).trim().split("\\s*\\|\\s*");
    }

    /**
     * Parses a string of numbers separated by spaces into a Set of Integers.
     *
     * @param numbers A string containing numbers separated by spaces.
     * @return A Set of integers parsed from the input string.
     */
    private Set<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}