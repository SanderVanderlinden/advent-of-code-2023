package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day01.Day01Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day01.Day01Puzzle02Solver;
import com.sandervanderlinden.adventofcode2023.day01.Day01PuzzleSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day01PuzzleSolverTest {

    private final Day01PuzzleSolver solver01 = new Day01Puzzle01Solver();
    private final Day01PuzzleSolver solver02 = new Day01Puzzle02Solver();

    @Test
    void Day01Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day01/day01_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());

        long actual = (long) result;
        int expectedSum = 54644;
        assertEquals(expectedSum, actual);
    }

    @Test
    void Day01Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day01/day01_input.txt");
        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        
        long actual = (long) result;
        int expectedSum = 53348;
        assertEquals(expectedSum, actual);
    }
}
