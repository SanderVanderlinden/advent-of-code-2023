package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day10.Day10Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day10.Day10Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day10PuzzleSolverTest {

    private final Day10Puzzle01Solver solver01 = new Day10Puzzle01Solver();
    private final Day10Puzzle02Solver solver02 = new Day10Puzzle02Solver();

    @Test
    void Day10Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day10/day10_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (long) result;
        long expectedLocationNumber = 7005;
        assertEquals(expectedLocationNumber, actual);
    }

    @Test
    void Day10Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day10/day10_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (long) result;
        long expectedLocationNumber = 417;
        assertEquals(expectedLocationNumber, actual);
    }
}
