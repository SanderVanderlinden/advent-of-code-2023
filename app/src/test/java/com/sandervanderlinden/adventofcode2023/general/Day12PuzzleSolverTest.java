package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day12.Day12Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day12PuzzleSolverTest {

    private final Day12Puzzle01Solver solver01 = new Day12Puzzle01Solver();

    @Test
    void Day12Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day12/day12_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());

        long actual = (long) result;
        long expectedLocationNumber = 0;
        assertEquals(expectedLocationNumber, actual);
    }
}
