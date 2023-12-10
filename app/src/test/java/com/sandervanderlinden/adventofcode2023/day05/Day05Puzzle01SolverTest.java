package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceInterval;
import com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Puzzle01SolverTest {

    private final Day05Puzzle01Solver solver = new Day05Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 35;
        String filepath = "day05/day05_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long");
        long actual = (Long) result;

        assertEquals(expected, actual);
    }


    @Test
    void testCreateSeedMap() {
        String exampleLine = "1366623789 166330978 138490835 1175000149 927454202 5492211";

        solver.initializeResourceState(exampleLine);

        Deque<ResourceInterval> expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(1366623789L, 1L));
        expected.add(new ResourceInterval(166330978L, 1L));
        expected.add(new ResourceInterval(138490835L, 1L));
        expected.add(new ResourceInterval(1175000149L, 1L));
        expected.add(new ResourceInterval(927454202L, 1L));
        expected.add(new ResourceInterval(5492211L, 1L));

        var actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

    }

    @Test
    void testMapSeedsValues() {
        solver.initializeSolver();
        solver.initializeResourceState("seeds: 79 14 55 13");

        solver.addConversionRange(NumberExtractionUtility.extractNumbersAsLongStream("50 98 2").toList());
        solver.addConversionRange(NumberExtractionUtility.extractNumbersAsLongStream("52 50 48").toList());
        solver.prepareNextResourceState();

        Deque<ResourceInterval> expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(81L, 1L));
        expected.add(new ResourceInterval(14L, 1L));
        expected.add(new ResourceInterval(57L, 1L));
        expected.add(new ResourceInterval(13L, 1L));
        var actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

        solver.addConversionRange(NumberExtractionUtility.extractNumbersAsLongStream("0 15 37").toList());
        solver.addConversionRange(NumberExtractionUtility.extractNumbersAsLongStream("37 52 2").toList());
        solver.addConversionRange(NumberExtractionUtility.extractNumbersAsLongStream("39 0 15").toList());
        solver.prepareNextResourceState();

        expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(81L, 1L));
        expected.add(new ResourceInterval(53L, 1L));
        expected.add(new ResourceInterval(57L, 1L));
        expected.add(new ResourceInterval(52L, 1L));
        actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));    }
}