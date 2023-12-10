package com.sandervanderlinden.adventofcode2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day06Puzzle02SolverTest {

    private final Day06Puzzle02Solver solver = new Day06Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 71503;
        String filepath = "day06/day06_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a int");
        long actual = (Long) result;

        assertEquals(expected, actual);
    }

}