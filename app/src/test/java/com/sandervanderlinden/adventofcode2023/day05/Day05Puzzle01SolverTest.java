package com.sandervanderlinden.adventofcode2023.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05Puzzle01SolverTest {

    private final Day05Puzzle01Solver solver = new Day05Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 45;
        String filepath = "day04/day04_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be an integer");
        int actual = (Integer) result;

        assertEquals(expected, actual);
    }
}