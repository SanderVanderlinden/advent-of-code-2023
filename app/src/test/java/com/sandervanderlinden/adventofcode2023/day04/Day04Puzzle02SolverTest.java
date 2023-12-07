package com.sandervanderlinden.adventofcode2023.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day04Puzzle02SolverTest {

    private final Day04Puzzle02Solver solver = new Day04Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 30;
        String filepath = "day04/day04_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be an integer");
        int actual = (Integer) result;

        assertEquals(expected, actual);
    }
}