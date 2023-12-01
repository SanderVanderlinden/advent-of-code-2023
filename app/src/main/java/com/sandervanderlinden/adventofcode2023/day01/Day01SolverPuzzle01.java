package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01SolverPuzzle01 implements Day01Solver{

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        InputStream inputStream = Day01SolverPuzzle01.class.getResourceAsStream("/day01/day01_input.txt");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Day01SolverPuzzle01 solver = new Day01SolverPuzzle01();
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
