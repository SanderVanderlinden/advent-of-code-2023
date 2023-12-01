package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solver for Day 1 Puzzle 1 of Advent of Code 2023.
 * This solver extracts digits from textual representations and combines them for processing.
 */
public class Day01Puzzle01Solver implements Day01PuzzleSolver {

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day01PuzzleSolver solver = new Day01Puzzle01Solver();
        int sum = FileReaderUtil.processFile("/day01/day01_input.txt", solver::extractAndCombineDigits);
        System.out.println("Total sum: " + sum);
    }

    /**
     * Extracts the first digit from a given line.
     *
     * @param line The string line to extract the first digit from.
     * @return The first digit found in the line.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    public int extractFirstDigit(String line) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NoDigitFoundException("No digits found in the line: " + line);
    }

    /**
     * Extracts the last digit from a given line by reversing it and using extractFirstDigit.
     *
     * @param line The string line to extract the last digit from.
     * @return The last digit found in the line.
     */
    public int extractLastDigit(String line) {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return extractFirstDigit(reversedLine);
    }
}
