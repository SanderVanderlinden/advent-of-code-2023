package com.sandervanderlinden.adventofcode2023.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day08Puzzle01SolverTest {

    private final Day08Puzzle01Solver solver = new Day08Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 2;
        String filepath = "day08/day08_test_input_01.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        long actual = (Integer) result;

        assertEquals(expected, actual);


        expected = 6;
        filepath = "day08/day08_test_input.txt_02";
        result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        actual = (Integer) result;

        assertEquals(expected, actual);
    }

}