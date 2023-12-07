package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.common.LineSumPuzzleSolver;
import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

/**
 * Abstract class representing a generic solver for Day 1 puzzles of Advent of Code 2023.
 * This class provides common methods to process input data and extract digits from strings.
 */
public abstract class Day01PuzzleSolver extends LineSumPuzzleSolver {


    /**
     * Extracts the first and last digit from a given line and combines them to form a two-digit number.
     * The first digit becomes the tens place, and the last digit becomes the ones place in the resulting number.
     *
     * @param line The string line from which digits are to be extracted.
     */
    @Override
    public int extractValueFromLine(String line) {
        int firstNumber = extractFirstDigit(line);
        int lastNumber = extractLastDigit(line);
        return firstNumber * 10 + lastNumber;
    }

    /**
     * Extracts the first digit found in a given string line.
     *
     * @param line The string line to extract the first digit from.
     * @return The first digit as an integer.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    abstract int extractFirstDigit(String line) throws NoDigitFoundException;

    /**
     * Extracts the last digit from a given string line.
     * This is achieved by reversing the line and using the extractFirstDigit method.
     *
     * @param line The string line to extract the last digit from.
     * @return The last digit as an integer.
     */
    abstract int extractLastDigit(String line);

}

