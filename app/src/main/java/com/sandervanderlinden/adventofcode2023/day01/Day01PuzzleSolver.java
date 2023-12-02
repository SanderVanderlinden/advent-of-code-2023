package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

public interface Day01PuzzleSolver {


    /**
     * Solves the puzzle by processing the file specified by filePath.
     * It applies the extractAndCombineDigits method to each line of the file
     * to calculate a combined sum of the processed digits.
     *
     * @param filePath The relative path of the file to be processed.
     * @return The sum of the processed digits as an integer.
     */
    default int solve(String filePath) {
        return FileReaderUtil.processFile(filePath, this::extractAndCombineDigits);
    }

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