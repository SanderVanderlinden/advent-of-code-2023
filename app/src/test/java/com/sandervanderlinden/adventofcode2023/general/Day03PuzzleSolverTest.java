package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day03PuzzleSolverTest {

    private final Day03Puzzle01Solver solver01 = new Day03Puzzle01Solver();
    private final Day03Puzzle02Solver solver02 = new Day03Puzzle02Solver();

    @Test
    void Day03Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day03/day03_input.txt");
        assertTrue(result instanceof Integer, "Result should be an integer");

        int actual = (Integer) result;
        int expectedSum = 512794;
        assertEquals(expectedSum, actual);
    }
    @Test
    void Day03Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day03/day03_input.txt");
        assertTrue(result instanceof Integer, "Result should be an integer");

        int actual = (Integer) result;
        int expectedSum = 67779080;
        assertEquals(expectedSum, actual);
    }
}
