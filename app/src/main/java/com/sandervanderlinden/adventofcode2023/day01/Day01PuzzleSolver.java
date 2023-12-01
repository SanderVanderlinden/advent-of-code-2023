package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

interface Day01PuzzleSolver {

    /**
     * Extracts the first and last digit from a line and combines them into a two-digit number.
     *
     * @param line The string line to extract digits from.
     * @return Combined two-digit number.
     */
    default int extractAndCombineDigits(String line) {
        int firstNumber = extractFirstDigit(line);
        int lastNumber = extractLastDigit(line);
        return firstNumber * 10 + lastNumber;
    }

    int extractFirstDigit(String line) throws NoDigitFoundException;

    int extractLastDigit(String line);
}