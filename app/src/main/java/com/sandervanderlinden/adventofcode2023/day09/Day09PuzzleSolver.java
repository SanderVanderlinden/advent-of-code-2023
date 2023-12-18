package com.sandervanderlinden.adventofcode2023.day09;

import com.sandervanderlinden.adventofcode2023.common.LineSumPuzzleSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for solving Day 09 puzzles in the Advent of Code 2023.
 */
public abstract class Day09PuzzleSolver extends LineSumPuzzleSolver {

    long calculateValue(List<Long> extractNumbersAsList) {
        long sum = 0;
        List<Long> currentSequence = extractNumbersAsList;
        while (!allZeros(currentSequence)) {
            sum += currentSequence.get(currentSequence.size() - 1);
            currentSequence = calculateNextSequence(currentSequence);
        }
        return sum;
    }

    List<Long> calculateNextSequence(List<Long> currentSequence) {
        ArrayList<Long> nextSequence = new ArrayList<>();
        int index = 0;
        while (index < currentSequence.size() - 1) {
            nextSequence.add(currentSequence.get(index + 1) - currentSequence.get(index));
            index += 1;
        }
        return nextSequence;
    }

    boolean allZeros(List<Long> currentSequence) {
        return currentSequence.stream().allMatch(number -> number == 0);
    }
}
