package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day04.Day04Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day04.Day04Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day04PuzzleSolverTest {

    private final Day04Puzzle01Solver solver01 = new Day04Puzzle01Solver();
    private final Day04Puzzle02Solver solver02 = new Day04Puzzle02Solver();

    @Test
    void Day04Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day04/day04_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());

        long actual = (long) result;
        int expectedSum = 24175;
        assertEquals(expectedSum, actual);
    }

    @Test
    void Day04Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day04/day04_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());

        long actual = (long) result;
        int expectedSum = 18846301;
        assertEquals(expectedSum, actual);
    }

}
