package com.sandervanderlinden.adventofcode2023.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day09Puzzle01SolverTest {

    private final Day09Puzzle01Solver solver = new Day09Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 0;
        String filepath = "day09/day09_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        long actual = (Integer) result;

        assertEquals(expected, actual);
    }
}