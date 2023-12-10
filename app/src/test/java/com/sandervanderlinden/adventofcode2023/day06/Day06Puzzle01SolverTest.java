package com.sandervanderlinden.adventofcode2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day06Puzzle01SolverTest {

    private final Day06Puzzle01Solver solver = new Day06Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 288;
        String filepath = "day06/day06_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a int");
        long actual = (Long) result;

        assertEquals(expected, actual);
    }

}