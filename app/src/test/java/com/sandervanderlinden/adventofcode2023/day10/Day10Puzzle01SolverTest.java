package com.sandervanderlinden.adventofcode2023.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day10Puzzle01SolverTest {

    private final Day10Puzzle01Solver solver = new Day10Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 4;
        String filepath = "day10/day10_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }
}