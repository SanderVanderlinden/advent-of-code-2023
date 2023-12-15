package com.sandervanderlinden.adventofcode2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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


    @Test
    void processLine_withTimeLine_updatesTimesList() {
        String line = "Time:        55     82     64     90";
        solver.processLine(line);
        assertTrue(solver.times.contains(55826490L));
    }

    @Test
    void processLine_withDistanceLine_updatesDistancesList() {
        String line = "Distance:   246   1441   1012   1111";
        solver.processLine(line);
        assertTrue(solver.distances.contains(246144110121111L));
    }

    @Test
    void processLine_withOtherLine_doesNotUpdateLists() {
        String line = "Other:   246   1441   1012   1111";
        solver.processLine(line);
        assertFalse(solver.times.contains(246144110121111L));
        assertFalse(solver.distances.contains(246144110121111L));
    }

}