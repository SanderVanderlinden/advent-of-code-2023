package com.sandervanderlinden.adventofcode2023.day06;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Abstract class for solving Day 6 puzzles in the Advent of Code 2023.
 */
public abstract class Day06PuzzleSolver implements BasePuzzleSolver {


    List<Long> times = new ArrayList<>();
    List<Long> distances = new ArrayList<>();


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

    private long numberOfPossibleWins(long timeTotal, long distanceToBeat) {
        long timeWinWithSmallestButtonTime = findTimeWinWithSmallestButtonTime(timeTotal, distanceToBeat);
        return timeTotal + 1 - 2 * timeWinWithSmallestButtonTime;
    }

    private long findTimeWinWithSmallestButtonTime(long timeTotal, long distanceToBeat) {
        //Can be more efficient by making use of symmetry
        for (int timeButton = 0; timeButton <= timeTotal; timeButton++) {
            if (calculateDistance(timeTotal, timeButton) > distanceToBeat) {
                return timeButton;
            }
        }
        return 0;
    }

    private long calculateDistance(long timeTotal, long timeButton) {
        return timeButton * (timeTotal - timeButton);
    }


}
