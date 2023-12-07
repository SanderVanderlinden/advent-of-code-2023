package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.logging.Logger;

/**
 * Abstract class for Day 5 puzzles in Advent of Code 2023.-
 */
public abstract class Day05PuzzleSolver implements BasePuzzleSolver {

    static void checkResult(Object result, Logger logger) {
        if (result instanceof Integer locationNumber) {
            String message = String.format("Lowest location number: %d", locationNumber);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result;
            logger.warning(message);
        }
    }


}
