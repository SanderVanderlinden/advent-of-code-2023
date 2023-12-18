package com.sandervanderlinden.adventofcode2023.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day09Puzzle02SolverTest {

    private final Day09Puzzle02Solver solver = new Day09Puzzle02Solver();

    @Test
    void testSolve() {
        int expected = 2;
        String filepath = "day09/day09_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }

    @Test
    void testExtractValueFromLine() {
        String line = "1 3 6 10 15 21";
        int expected = 0;
        assertEquals(expected, solver.extractValueFromLine(line));

        line = "0 3 6 9 12 15";
        expected = -3;
        assertEquals(expected, solver.extractValueFromLine(line));

        line = "10 13 16 21 30 45";
        expected = 5;
        assertEquals(expected, solver.extractValueFromLine(line));
    }
}