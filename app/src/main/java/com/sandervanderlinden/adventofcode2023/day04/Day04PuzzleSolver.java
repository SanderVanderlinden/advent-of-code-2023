package com.sandervanderlinden.adventofcode2023.day04;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Abstract class for Day 4 puzzles in Advent of Code 2023.-
 */
public abstract class Day04PuzzleSolver implements BasePuzzleSolver {


    /**
     * Parses a line from the input file to extract the winning and own numbers.
     * The method assumes the line is formatted with a colon and a pipe symbol separating the numbers.
     *
     * @param line A single line from the input file.
     * @return An array of two strings, where the first element is the string of winning numbers
     *         and the second is the string of own numbers.
     */
    String[] parseLine(String line) {
        return line.substring(line.indexOf(":") + 1).trim().split("\\s*\\|\\s*");
    }

    /**
     * Parses a string of numbers separated by spaces into a Set of Integers.
     *
     * @param numbers A string containing numbers separated by spaces.
     * @return A Set of integers parsed from the input string.
     */
    Set<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


    int getAmountOfMatchingNumbers(String line) {
        int output = 0;
        String[] numberGroups = parseLine(line);

        Set<Integer> winningNumbers = parseNumbers(numberGroups[0]);
        Set<Integer> ownNumbers = parseNumbers(numberGroups[1]);

        for (Integer number : winningNumbers) {
            if (ownNumbers.contains(number)) {
                output += 1;
            }
        }
        return output;
    }

}
