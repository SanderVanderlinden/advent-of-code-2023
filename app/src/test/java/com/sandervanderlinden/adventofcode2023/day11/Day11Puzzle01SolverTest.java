package com.sandervanderlinden.adventofcode2023.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day11Puzzle01SolverTest {

    private final Day11Puzzle01Solver solver = new Day11Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 374;
        String filepath = "day11/day11_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }
}