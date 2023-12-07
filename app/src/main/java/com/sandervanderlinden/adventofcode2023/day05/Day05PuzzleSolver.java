package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.*;
import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility.extractNumbersAsStream;

/**
 * Abstract class for Day 5 puzzles in Advent of Code 2023.-
 */
public abstract class Day05PuzzleSolver implements BasePuzzleSolver {

    Set<Long> currentSet = new HashSet<>();
    private final Map<Long, Long> currentSetToNextSet = new HashMap<>();


    static void checkResult(Object result, Logger logger) {
        if (result instanceof Long locationNumber) {
            String message = String.format("Lowest location number: %d", locationNumber);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result.getClass();
            logger.warning(message);
        }
    }

    @Override
    public void processLine(String line) {
        if (line.isEmpty()) {
            return;
        }
        if (line.startsWith("seeds:")) {
            createSeedSet(line);
        }
        else if (line.endsWith("map:")) {
            transferToNextSet();
        }
        else {
            buildNextSet(extractNumbersAsStream(line).toList());
        }
    }

    abstract void createSeedSet(String line);


    void transferToNextSet() {
        currentSet.forEach(item -> currentSetToNextSet.putIfAbsent(item, item));
        currentSet = new HashSet<>(currentSetToNextSet.values());

        currentSetToNextSet.clear();
    }

    void buildNextSet(List<Long> integers) {
        long destinationRangeStart = integers.get(0);
        long sourceRangeStart = integers.get(1);
        long rangeLength = integers.get(2);

        for (Long item : currentSet) {
            if (item >= sourceRangeStart && item < sourceRangeStart + rangeLength) {
                currentSetToNextSet.put(item, item + destinationRangeStart - sourceRangeStart);
            }
        }
    }

    @Override
    public Object finalizeSolver() {
        transferToNextSet();
        return currentSet.stream().min(Long::compare).orElse(null);
    }
}
