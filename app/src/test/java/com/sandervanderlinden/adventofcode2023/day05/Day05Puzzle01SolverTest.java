package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.util.NumberExtractionUtility;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

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

        solver.createSeedSet(exampleLine);

        Set<Long> expected = Set.of(1366623789L, 166330978L, 138490835L, 1175000149L, 927454202L, 5492211L);

        assertEquals(expected, solver.currentSet, "The created seed map should match the expected map");
    }

    @Test
    void testBuildNextSet() {
        solver.initializeSolver();
        solver.createSeedSet(("79 14 55 13"));

        String firstLine = "50 98 2";
        String secondLine = "52 50 48";
        solver.buildNextSet(NumberExtractionUtility.extractNumbersAsStream(firstLine).toList());
        solver.buildNextSet(NumberExtractionUtility.extractNumbersAsStream(secondLine).toList());
        solver.transferToNextSet();

        Set<Long> expected = Set.of(13L, 14L, 57L, 81L);

        assertEquals(expected, solver.currentSet);
    }

    @Test
    void testMapSeedsValues() {
        solver.initializeSolver();
        solver.createSeedSet("seeds: 79 14 55 13");

        String firstLine = "50 98 2";
        List<Long> firstLineList = NumberExtractionUtility.extractNumbersAsStream(firstLine).toList();
        solver.buildNextSet(firstLineList);

        String secondLine = "52 50 48";
        List<Long> secondLineList = NumberExtractionUtility.extractNumbersAsStream(secondLine).toList();
        solver.buildNextSet(secondLineList);
        solver.transferToNextSet();

        Set<Long> expected = Set.of(81L, 14L, 57L, 13L);

        assertEquals(expected, solver.currentSet);


        String secondMapFirstLine = "0 15 37";
        List<Long> secondMapFirstLineList = NumberExtractionUtility.extractNumbersAsStream(secondMapFirstLine).toList();
        solver.buildNextSet(secondMapFirstLineList);

        String secondMapSecondLine = "37 52 2";
        List<Long> secondMapSecondLineList = NumberExtractionUtility.extractNumbersAsStream(secondMapSecondLine).toList();
        solver.buildNextSet(secondMapSecondLineList);

        String secondMapThirdLine = "39 0 15";
        List<Long> secondMapThirdLineList = NumberExtractionUtility.extractNumbersAsStream(secondMapThirdLine).toList();
        solver.buildNextSet(secondMapThirdLineList);
        solver.transferToNextSet();

        Set<Long> expectedAfterSecondMapping = Set.of(81L, 53L, 57L, 52L);

        assertEquals(expectedAfterSecondMapping, solver.currentSet);
    }
}