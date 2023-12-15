package com.sandervanderlinden.adventofcode2023.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void processLine_withTimeLine_updatesTimesList() {
        String line = "Time:        55     82     64     90";
        solver.processLine(line);
        assertTrue(solver.times.contains(55L));
    }

    @Test
    void processLine_withDistanceLine_updatesDistancesList() {
        String line = "Distance:   246   1441   1012   1111";
        solver.processLine(line);
        assertTrue(solver.distances.contains(246L));
    }

    @Test
    void processLine_withOtherLine_doesNotUpdateLists() {
        String line = "Other:   246   1441   1012   1111";
        solver.processLine(line);
        assertFalse(solver.times.contains(246L));
        assertFalse(solver.distances.contains(246L));
    }

}