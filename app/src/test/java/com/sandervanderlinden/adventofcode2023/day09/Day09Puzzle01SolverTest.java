package com.sandervanderlinden.adventofcode2023.day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractNumbersAsList;
import static org.junit.jupiter.api.Assertions.*;

class Day09Puzzle01SolverTest {

    private final Day09Puzzle01Solver solver = new Day09Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 114;
        String filepath = "day09/day09_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        long actual = (Integer) result;

        assertEquals(expected, actual);
    }

    @Test
    void testExtractValueFromLine() {
        String line = "3 10 23 46 99 234 563 1310 2904 6131 12351 23745 43470 75464 123501 189097 268370 349700 418439 484617 669380";
        int expected = 2658546;
        assertEquals(expected, solver.extractValueFromLine(line));
    }

    @Test
    void testCalculateNextSequence() {
        List<Long> line = extractNumbersAsList("3 10 23 46 99 234 563 1310 2904 6131 12351 23745 43470 75464 123501 189097 268370 349700 418439 484617 669380");
        List<Long> expected = extractNumbersAsList("7 13 23 53 135 329 747 1594 3227 6220 11394 19725 31994 48037 65596 79273 81330 68739 66178 184763");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("6 10 30 82 194 418 847 1633 2993 5174 8331 12269 16043 17559 13677 2057 12591 2561 118585");
        assertEquals(expected, solver.calculateNextSequence(line));
    }

    @Test
    void testCalculateNextSequenceWithNegativeNumbers() {
        List<Long> line = extractNumbersAsList("10 5 -5 -20 -40 -65 -95 -130 -170 -215 -265 -320 -380 -445 -515 -590 -670 -755 -845 -940 -1040");
        List<Long> expected = extractNumbersAsList("5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        assertEquals(expected, solver.calculateNextSequence(line));
    }

    @Test
    void testAllZeros() {
        List<Long> line = extractNumbersAsList("10 5 -5 -20 -40 -65 -95 -130 -170 -215 -265 -320 -380 -445 -515 -590 -670 -755 -845 -940 -1040");
        assertFalse(solver.allZeros(line));

        line = extractNumbersAsList("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        assertTrue(solver.allZeros(line));
    }
}