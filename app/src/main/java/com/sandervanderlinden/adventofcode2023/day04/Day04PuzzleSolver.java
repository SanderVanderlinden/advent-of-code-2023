package com.sandervanderlinden.adventofcode2023.day04;

import com.sandervanderlinden.adventofcode2023.common.LineSumPuzzleSolver;

import java.util.Map;
import java.util.Set;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractLotteryNumbers;

/**
 * Abstract class for Day 4 puzzles in Advent of Code 2023.-
 */
public abstract class Day04PuzzleSolver extends LineSumPuzzleSolver {

    int getAmountOfMatchingNumbers(String line) {
        int output = 0;
        Map<String, Set<Integer>> numberGroups = extractLotteryNumbers(line);

        Set<Integer> winningNumbers = numberGroups.get("winningNumbers");
        Set<Integer> ownNumbers = numberGroups.get("ownNumbers");

        for (Integer number : winningNumbers) {
            if (ownNumbers.contains(number)) {
                output += 1;
            }
        }
        return output;
    }
}
