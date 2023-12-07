package com.sandervanderlinden.adventofcode2023.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Puzzle02SolverTest {

    private final Day05Puzzle01Solver solver = new Day05Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 46;
        String filepath = "day05/day05_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long");
        long actual = (Long) result;

        assertEquals(expected, actual);
    }
}