package com.sandervanderlinden.adventofcode2023.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day07Puzzle01SolverTest {

    private final Day07Puzzle01Solver solver = new Day07Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 6440;
        String filepath = "day07/day07_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        long actual = (Integer) result;

        assertEquals(expected, actual);
    }

}