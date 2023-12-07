package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day05.Day05Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day05PuzzleSolverTest {

    private final Day05Puzzle01Solver solver01 = new Day05Puzzle01Solver();

    @Test
    void Day04Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day05/day05_input.txt");
        assertTrue(result instanceof Long, "Result should be a long");

        long actual = (Long) result;
        int expectedLocationNumber = 84470622;
        assertEquals(expectedLocationNumber, actual);
    }


}
