package com.sandervanderlinden.adventofcode2023.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day04Puzzle01SolverTest {

    private final Day04Puzzle01Solver solver = new Day04Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 13;
        String filepath = "day04/day04_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long");
        long actual = (long) result;

        assertEquals(expected, actual);
    }
}