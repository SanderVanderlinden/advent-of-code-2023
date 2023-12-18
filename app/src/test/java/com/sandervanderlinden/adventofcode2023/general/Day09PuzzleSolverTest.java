package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day09.Day09Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day09.Day09Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day09PuzzleSolverTest {

    private final Day09Puzzle01Solver solver01 = new Day09Puzzle01Solver();
    private final Day09Puzzle02Solver solver02 = new Day09Puzzle02Solver();

    @Test
    void Day09Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day09/day09_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (long) result;
        long expectedLocationNumber = 2174807968L;
        assertEquals(expectedLocationNumber, actual);
    }

    @Test
    void Day09Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day09/day09_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (long) result;
        long expectedLocationNumber = 1208;
        assertEquals(expectedLocationNumber, actual);
    }
}
