package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.day05.resources.ResourceInterval;
import com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Puzzle02SolverTest {

    private final Day05Puzzle02Solver solver = new Day05Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 46;
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
        expected.add(new ResourceInterval(1366623789L, 166330978L));
        expected.add(new ResourceInterval(138490835L, 1175000149L));
        expected.add(new ResourceInterval(927454202L, 5492211L));

        var actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

    }

    @Test
    void testMapSeedsValues() {
        solver.initializeSolver();
        solver.initializeResourceState("seeds: 79 14 55 13");

        // seed-to-soil map:
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("50 98 2").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("52 50 48").toList());
        solver.prepareNextResourceState();

        Deque<ResourceInterval> expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(81L, 14L));
        expected.add(new ResourceInterval(57L, 13L));
        var actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

        // soil-to-fertilizer map:
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("0 15 37").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("37 52 2").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("39 0 15").toList());
        solver.prepareNextResourceState();

        expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(81L, 14L));
        expected.add(new ResourceInterval(57L, 13L));
        actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

        // fertilizer-to-water map:
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("49 53 8").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("0 11 42").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("42 0 7").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("57 7 4").toList());
        solver.prepareNextResourceState();

        expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(81L, 14L));
        expected.add(new ResourceInterval(53L, 4L));
        expected.add(new ResourceInterval(61L, 9L));
        actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

        // water-to-light map:
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("88 18 7").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("18 25 70").toList());
        solver.prepareNextResourceState();

        expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(74L, 14L));
        expected.add(new ResourceInterval(46L, 4L));
        expected.add(new ResourceInterval(54L, 9L));
        actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));

        // light-to-temperature map:
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("45 77 23").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("81 45 19").toList());
        solver.addConversionRange(LineProcessingUtility.extractNumbersAsLongStream("68 64 13").toList());
        solver.prepareNextResourceState();

        expected = new ArrayDeque<>();
        expected.add(new ResourceInterval(45L, 11L));
        expected.add(new ResourceInterval(82L, 4L));
        expected.add(new ResourceInterval(90L, 9L));
        expected.add(new ResourceInterval(78L, 3L));
        actual = solver.currentResourceState.getIntervals();
        assertEquals(new ArrayList<>(expected), new ArrayList<>(actual));
    }
}
