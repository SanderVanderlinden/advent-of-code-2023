package com.sandervanderlinden.adventofcode2023.day05;


import java.util.*;
import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility.extractNumbersAsStream;
import static java.util.stream.Collectors.toSet;

/**
 * This class solves the first puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic to process lines of input
 * and calculate a final output based on the puzzle's rules.
 */
public class Day05Puzzle01Solver extends Day05PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day05Puzzle01Solver.class.getName());
    Set<Long> currentSet;
    Map<Long, Long> currentSetToNextSet;
    Set<Long> nextSet;


    /**
     * The main method that initializes the solver, processes the input file,
     * and logs the total sum calculated by the solver.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day05Puzzle01Solver solver = new Day05Puzzle01Solver();
        Object result = solver.solve("day05/day05_input.txt");
        checkResult(result, logger);
    }

    @Override
    public void initializeSolver() {
        nextSet = new HashSet<>();
        currentSetToNextSet = new HashMap<>();
    }

    @Override
    public void processLine(String line) {
if (line.startsWith("seeds:")) {
            createSeedSet(line);
        }
        else if (line.endsWith("map:")) {
            updateMaps();
        }
        else {
            buildNextSet(extractNumbersAsStream(line).toList());
        }
    }

    void updateMaps() {
        currentSet.forEach(item -> {
            if (!currentSetToNextSet.containsKey(item)) {
                currentSetToNextSet.put(item, item);
            }
        });
        currentSet = new HashSet<>(currentSetToNextSet.values());

        currentSetToNextSet = new HashMap<>();
        nextSet = new HashSet<>();
    }

    void buildNextSet(List<Long> integers) {
        long destinationRangeStart = integers.get(0);
        long sourceRangeStart = integers.get(1);
        long rangeLength = integers.get(2);

        for (Long item : currentSet) {
            if (item >= sourceRangeStart && item < sourceRangeStart + rangeLength){
                currentSetToNextSet.put(item, item + destinationRangeStart - sourceRangeStart);
            }
        }
    }

    void createSeedSet(String line) {
        currentSet = extractNumbersAsStream(line)
                .collect(toSet());
    }

    @Override
    public Object finalizeSolver() {
        updateMaps();
        Optional<Long> smallest = currentSet
                .stream()
                .min(Long::compare);

        return smallest.orElse(null);
    }

}