package com.sandervanderlinden.adventofcode2023.day06;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.List;
import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility.extractNumbersAsList;

/**
 * Abstract class for solving Day 6 puzzles in the Advent of Code 2023.
 */
public abstract class Day06PuzzleSolver implements BasePuzzleSolver {


    private List<Integer> times;
    private List<Integer> distances;

    static void logResult(Object result, Logger logger) {
        if (result instanceof Integer wins) {
            String message = String.format("Number of possible wins: %d", wins);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result.getClass();
            logger.warning(message);
        }
    }

    @Override
    public void processLine(String line) {
        if (line.startsWith("Time:")) {
            times = extractNumbersAsList(line);
        }
        else if (line.startsWith("Distance:")) {
            distances = extractNumbersAsList(line);
        }
    }

    @Override
    public Object finalizeSolver() {
        int solution = 1;
        for (int i = 0; i < times.size(); i++) {
            solution *= numberOfPossibleWins(times.get(i), distances.get(i));
        }
        return solution;
    }

    private int numberOfPossibleWins(Integer time, Integer distanceToBeat) {
        int result = 0;
        //Can be more efficient by making use of symmetry and finding the first possible win by halving the interval repeatedly.
        for (int i = 0; i <= time; i++) {
            if (calculateDistance(time, i) > distanceToBeat) {
                result += 1;
            }
        }
        return result;
    }

    private int calculateDistance(int time, int i) {
        return i * (time - i);
    }


}
