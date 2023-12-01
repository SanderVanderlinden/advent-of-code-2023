package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Day01Puzzle02Solver implements Day01PuzzleSolver {

    Map<String, Integer> singleDigits = Map.of(
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

    Map<String, Integer> textualNumbers = Map.of(
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

    Map<String, Integer> reversedTextualNumbers = Map.of(
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


    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        InputStream inputStream = Day01Puzzle02Solver.class.getResourceAsStream("/day01/day01_input.txt");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Day01Puzzle02Solver solver = new Day01Puzzle02Solver();
            int sum = reader.lines()
                    .mapToInt(solver::extractAndCombineDigits)
                    .sum();
            System.out.println("Total sum: " + sum);
        } else {
            System.err.println("Input file not found");
        }
    }

    /**
     * Extracts the first and last digit from a line and combines them into a two-digit number.
     *
     * @param line The string line to extract digits from.
     * @return Combined two-digit number.
     */
    public int extractAndCombineDigits(String line) {
        int firstNumber = extractFirstDigit(line);
        int lastNumber = extractLastDigit(line);
        return firstNumber * 10 + lastNumber;
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

    private int findFirstSubstring(String line, Map<String, Integer> digits) {
        return digits.entrySet().stream()
                .filter(entry -> line.contains(entry.getKey()))
                .min(Comparator.comparingInt(entry -> line.indexOf(entry.getKey())))
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new NoDigitFoundException("No digits found in the line: " + line));
    }

}
