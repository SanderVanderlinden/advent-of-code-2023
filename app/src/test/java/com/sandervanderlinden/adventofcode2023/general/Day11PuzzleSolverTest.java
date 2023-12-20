package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day11.Day11Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day11PuzzleSolverTest {

    private final Day11Puzzle01Solver solver01 = new Day11Puzzle01Solver();

    @Test
    void Day11Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day11/day11_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());


        long actual = (long) result;
        long expectedLocationNumber = 0;
        assertEquals(expectedLocationNumber, actual);
    }
}
