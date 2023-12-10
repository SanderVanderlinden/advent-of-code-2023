package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day06.Day06Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day06.Day06Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day06PuzzleSolverTest {

    private final Day06Puzzle01Solver solver01 = new Day06Puzzle01Solver();
    private final Day06Puzzle02Solver solver02 = new Day06Puzzle02Solver();

    @Test
    void Day06Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day06/day06_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (Long) result;
        int expectedLocationNumber = 608902;
        assertEquals(expectedLocationNumber, actual);
    }

    @Test
    void Day06Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day06/day06_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (Long) result;
        int expectedLocationNumber = 46173809   ;
        assertEquals(expectedLocationNumber, actual);
    }


}
