package com.sandervanderlinden.adventofcode2023.day06;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.List;
import java.util.logging.Logger;

/**
 * Abstract class for solving Day 6 puzzles in the Advent of Code 2023.
 */
public abstract class Day06PuzzleSolver implements BasePuzzleSolver {


    List<Long> times;
    List<Long> distances;


    static void calculateAndLogResult(Day06Puzzle01Solver solver, Logger logger, String filePath) {
        Object result = solver.solve(filePath);
        logResult(result, logger);
    }

    static void logResult(Object result, Logger logger) {
        if (result instanceof Long wins) {
            String message = String.format("Number of possible wins: %d", wins);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result.getClass();
            logger.warning(message);
        }
    }


    @Override
    public Object finalizeSolver() {
        long solution = 1;
        for (int i = 0; i < times.size(); i++) {
            solution *= numberOfPossibleWins(times.get(i), distances.get(i));
        }
        return solution;
    }

    private int numberOfPossibleWins(long totalTime, long distanceToBeat) {
        int result = 0;
        //Can be more efficient by making use of symmetry and finding the first possible win by halving the interval repeatedly.
        for (int timeButtonHeld = 0; timeButtonHeld <= totalTime; timeButtonHeld++) {
            if (calculateDistance(totalTime, timeButtonHeld) > distanceToBeat) {
                result += 1;
            }
        }
        return result;
    }

    private long calculateDistance(long totalTime, long timeButtonHeld) {
        return timeButtonHeld * (totalTime - timeButtonHeld);
    }


}
