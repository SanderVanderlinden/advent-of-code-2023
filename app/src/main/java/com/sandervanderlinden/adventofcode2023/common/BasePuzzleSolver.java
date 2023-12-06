package com.sandervanderlinden.adventofcode2023.common;

import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

/**
 * Defines the basic structure and functionality for puzzle solvers in Advent of Code 2023.
 * It provides a common interface for all puzzle-solving classes.
 */
public interface BasePuzzleSolver {

    /**
     * Abstract method to process a line from the input file.
     * Each solver class will implement this method based on its specific logic.
     *
     * @param line A string representing a line from the puzzle input.
     * @return An integer value processed from the line.
     */
    int processLine(String line);

    /**
     * Processes the input file and aggregates results from each line.
     *
     * @param filePath The path to the input file.
     * @return The aggregated result of processing all lines in the file.
     */
    default int solve(String filePath) {
        return FileReaderUtil.processFile(filePath, this::processLine);
    }
}

