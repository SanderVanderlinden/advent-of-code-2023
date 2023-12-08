package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day02.Day02Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day02.Day02Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day02PuzzleSolverTest {

    private final Day02Puzzle01Solver solver01 = new Day02Puzzle01Solver();
    private final Day02Puzzle02Solver solver02 = new Day02Puzzle02Solver();

    @Test
    void Day02Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day02/day02_input.txt");
        assertTrue(result instanceof Integer, "Result should be an integer");

        int actual = (Integer) result;
        int expectedSum = 2369;
        assertEquals(expectedSum, actual);

    }

    @Test
    void Day02Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day02/day02_input.txt");
        assertTrue(result instanceof Integer, "Result should be an integer");

        int actual = (Integer) result;
        int expectedSum = 66363;
        assertEquals(expectedSum, actual);
    }
}
