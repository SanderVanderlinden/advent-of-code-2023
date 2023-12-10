package com.sandervanderlinden.adventofcode2023.day06;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for solving Day 6 puzzles in the Advent of Code 2023.
 */
public abstract class Day06PuzzleSolver implements BasePuzzleSolver {


    List<Long> times = new ArrayList<>();
    List<Long> distances = new ArrayList<>();


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
        long lowerBoundButtonTime = 1;
        long upperBoundButtonTime = timeTotal / 2;
        long midOfBoundsButtonTime = upperBoundButtonTime - (upperBoundButtonTime - lowerBoundButtonTime) / 2;
        while (lowerBoundButtonTime < upperBoundButtonTime - 1) {
            if (calculateDistance(timeTotal, midOfBoundsButtonTime) > distanceToBeat) {
                upperBoundButtonTime = midOfBoundsButtonTime;
            }
            else {
                lowerBoundButtonTime = midOfBoundsButtonTime;
            }
            midOfBoundsButtonTime = upperBoundButtonTime - (upperBoundButtonTime - lowerBoundButtonTime) / 2;
        }
        return midOfBoundsButtonTime;
    }

    private long calculateDistance(long timeTotal, long timeButton) {
        return timeButton * (timeTotal - timeButton);
    }


}
