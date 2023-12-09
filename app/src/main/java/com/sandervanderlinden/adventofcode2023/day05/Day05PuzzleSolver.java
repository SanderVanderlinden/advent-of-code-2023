package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceConversionRange;
import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceInterval;
import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceState;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility.extractNumbersAsLongStream;

/**
 * Abstract class for solving Day 5 puzzles in the Advent of Code 2023.
 * This class processes puzzle input line by line, manages resource states,
 * and handles resource interval overlaps based on conversion ranges.
 */
public abstract class Day05PuzzleSolver implements BasePuzzleSolver {

    private final Set<ResourceConversionRange> conversionRanges = new HashSet<>();

    ResourceState currentResourceState = new ResourceState();
    ResourceState nextResourceState = new ResourceState();

    /**
     * Logs the result of the puzzle solution.
     *
     * @param result The result object to be logged.
     * @param logger The logger used for logging the result.
     */
    static void logResult(Object result, Logger logger) {
        if (result instanceof Long locationNumber) {
            String message = String.format("Lowest location number: %d", locationNumber);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type:" + result.getClass();
            logger.warning(message);
        }
    }

    /**
     * Processes a single line of input from the puzzle.
     *
     * @param line The line of input to be processed.
     */
    @Override
    public void processLine(String line) {
        if (line.isEmpty()) return;

        if (line.startsWith("seeds:")) {
            initializeResourceState(line);
        }
        else if (line.endsWith("map:")) {
            prepareNextResourceState();
        }
        else {
            addConversionRange(extractNumbersAsLongStream(line).toList());
        }
    }

    /**
     * Abstract method to initialize the resource state from a given line.
     *
     * @param line The line containing initial resource state information.
     */
    abstract void initializeResourceState(String line);

    /**
     * Prepares the next resource state by processing intervals
     * and clearing conversion ranges.
     */
    void prepareNextResourceState() {
        nextResourceState = new ResourceState();
        processIntervals();
        conversionRanges.clear();
        currentResourceState = nextResourceState;
    }

    /**
     * Processes the intervals in the current resource state,
     * handling any overlaps with conversion ranges.
     */
    private void processIntervals() {
        while (!currentResourceState.getIntervals().isEmpty()) {
            ResourceInterval interval = currentResourceState.getIntervals().poll();
            if (!processOverlap(interval)) {
                nextResourceState.addInterval(interval);
            }
        }
    }

    /**
     * Processes the overlap of a given interval with the defined conversion ranges.
     *
     * @param interval The interval to be checked for overlaps.
     * @return true if an overlap is found and processed; false otherwise.
     */
    private boolean processOverlap(ResourceInterval interval) {
        for (ResourceConversionRange range : conversionRanges) {
            long overlapStart = Math.max(interval.start(), range.source());
            long overlapEnd = Math.min(interval.getEnd(), range.getSourceEnd());
            long overlapRange = overlapEnd - overlapStart;

            if (overlapRange > 0) {
                nextResourceState.addInterval(
                        new ResourceInterval(overlapStart + range.getSourceDestinationDifference(), overlapRange));
                addRemainingIntervals(interval, overlapStart, overlapEnd);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds any remaining intervals after processing an overlap.
     *
     * @param interval     The original interval being processed.
     * @param overlapStart The start of the overlap range.
     * @param overlapEnd   The end of the overlap range.
     */
    private void addRemainingIntervals(ResourceInterval interval, long overlapStart, long overlapEnd) {
        if (overlapStart > interval.start()) {
            currentResourceState.addInterval(new ResourceInterval(interval.start(), overlapStart - interval.start()));
        }
        if (overlapEnd < interval.getEnd()) {
            currentResourceState.addInterval(new ResourceInterval(overlapEnd, interval.getEnd() - overlapEnd));
        }
    }

    /**
     * Adds a new conversion range from a list of long integers.
     *
     * @param integers The list of integers representing a conversion range.
     */
    void addConversionRange(List<Long> integers) {
        long destinationRangeStart = integers.get(0);
        long sourceRangeStart = integers.get(1);
        long rangeLength = integers.get(2);
        conversionRanges.add(new ResourceConversionRange(sourceRangeStart, destinationRangeStart, rangeLength));
    }

    /**
     * Finalizes the solver, preparing the next resource state and returning the minimum start value.
     *
     * @return The lowest start value from the resource intervals or null if none exists.
     */
    @Override
    public Long finalizeSolver() {
        prepareNextResourceState();
        return currentResourceState.getIntervals().stream()
                .map(ResourceInterval::start)
                .min(Comparator.naturalOrder())
                .orElse(null);
    }
}
