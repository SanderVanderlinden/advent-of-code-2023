package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solver for Day 1 Puzzle 2 of Advent of Code 2023.
 * This solver extracts digits from textual representations and combines them for processing.
 */
public class Day01Puzzle02Solver implements Day01PuzzleSolver {

    private static final Map<String, Integer> singleDigits = Map.of(
            "0", 0,
            "1", 1,
            "2", 2,
            "3", 3,
            "4", 4,
            "5", 5,
            "6", 6,
            "7", 7,
            "8", 8,
            "9", 9
    );

    private static final Map<String, Integer> textualNumbers = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    private static final Map<String, Integer> reversedTextualNumbers = Map.of(
            "orez", 0,
            "eno", 1,
            "owt", 2,
            "eerht", 3,
            "ruof", 4,
            "evif", 5,
            "xis", 6,
            "neves", 7,
            "thgie", 8,
            "enin", 9
    );
    private static final Logger logger = Logger.getLogger(Day01Puzzle02Solver.class.getName());


    /**
     * Main method for running the solver.
     */
    public static void main(String[] args) {
        Day01PuzzleSolver solver = new Day01Puzzle02Solver();
        int sum = solver.solve();
        logger.log(Level.INFO, "Total sum: {}", sum);
    }

    /**
     * Extracts the first digit from a given line.
     *
     * @param line The string line to extract the first digit from.
     * @return The first digit found in the line.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    public int extractFirstDigit(String line) {
        Map<String, Integer> digits = new HashMap<>();
        digits.putAll(singleDigits);
        digits.putAll(textualNumbers);

        return findFirstSubstring(line, digits);
    }

    /**
     * Extracts the last digit from a given line by reversing it and using extractFirstDigit.
     *
     * @param line The string line to extract the last digit from.
     * @return The last digit found in the line.
     */
    public int extractLastDigit(String line) {
        Map<String, Integer> digits = new HashMap<>();
        digits.putAll(singleDigits);
        digits.putAll(reversedTextualNumbers);

        String reversedLine = new StringBuilder(line).reverse().toString();
        return findFirstSubstring(reversedLine, digits);
    }

    /**
     * Finds the first occurrence of a digit (either numeric or textual) in the given line.
     *
     * @param line   The line to search for the digit.
     * @param digits A map of digit representations to their numeric values.
     * @return The numeric value of the first found digit.
     * @throws NoDigitFoundException if no digit representation is found in the line.
     */
    private int findFirstSubstring(String line, Map<String, Integer> digits) {
        return digits.entrySet().stream()
                .filter(entry -> line.contains(entry.getKey()))
                .min(Comparator.comparingInt(entry -> line.indexOf(entry.getKey())))
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new NoDigitFoundException("No digits found in the line: " + line));
    }

}
