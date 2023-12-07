package com.sandervanderlinden.adventofcode2023.common;

import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;

public interface BasePuzzleSolver {

    /**
     * Initializes or sets up the puzzle solver with necessary data or state.
     * This method can be used to perform any pre-processing before the main solving logic.
     */
    void initializeSolver();

    /**
     * Processes a single line from the input file.
     * Each solver class will implement this method based on its specific logic.
     *
     * @param line A string representing a line from the puzzle input.
     */
    void processLine(String line);

    /**
     * Executes the main logic of the puzzle solver.
     * This method can be overridden to implement the puzzle-specific solving strategy.
     *
     * @param filePath The path to the input file.
     * @return The result of the puzzle solving process.
     */
    default Object solve(String filePath) {
        initializeSolver();
        FileReaderUtil.processFile(filePath, this::processLine);
        return finalizeSolver();
    }

    /**
     * Finalizes the solving process and returns the result.
     * This method can be used to perform any post-processing or to return the final result.
     *
     * @return The final result of the puzzle solving process.
     */
    Object finalizeSolver();
}
