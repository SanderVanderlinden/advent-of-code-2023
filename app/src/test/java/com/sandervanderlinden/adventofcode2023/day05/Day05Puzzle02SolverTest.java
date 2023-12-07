package com.sandervanderlinden.adventofcode2023.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Puzzle02SolverTest {

    private final Day05Puzzle02Solver solver = new Day05Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 0;
        String filepath = "day05/day05_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be an integer");
        int actual = (Integer) result;

        assertEquals(expected, actual);
    }
}