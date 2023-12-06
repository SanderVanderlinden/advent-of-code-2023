package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete implementation of Day01PuzzleSolver for the second puzzle of Day 1.
 * This class provides specialized digit extraction methods and uses maps for digit conversion.
 */
public class Day01Puzzle02Solver extends Day01PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day01Puzzle02Solver.class.getName());

    private static final Map<String, Integer> singleDigits = new HashMap<>();
    private static final Map<String, Integer> textualNumbers = new HashMap<>();
    private static final Map<String, Integer> reversedTextualNumbers = new HashMap<>();

    static {
        initializeNumbers();
    }

    /**
     * Initializes the maps used for digit conversion.
     * Populates singleDigits, textualNumbers, and reversedTextualNumbers with appropriate mappings.
     */private static void initializeNumbers() {

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < words.length; i++) {
            singleDigits.put(String.valueOf(i), i);
            textualNumbers.put(words[i], i);
            reversedTextualNumbers.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
    }

    /**
     * Main method for running the solver.
     */
    public static void main(String[] args) {
        Day01PuzzleSolver solver = new Day01Puzzle02Solver();
        int sum = solver.solve("day01/day01_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }


    @Override
    public int extractFirstDigit(String line) {
        Map<String, Integer> digits = new HashMap<>();
        digits.putAll(singleDigits);
        digits.putAll(textualNumbers);

        return findFirstSubstring(line, digits);
    }

    @Override
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
