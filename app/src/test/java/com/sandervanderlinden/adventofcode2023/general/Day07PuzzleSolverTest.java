package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day07.Day07Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day07.Day07Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day07PuzzleSolverTest {

    private final Day07Puzzle01Solver solver01 = new Day07Puzzle01Solver();
    private final Day07Puzzle02Solver solver02 = new Day07Puzzle02Solver();

    @Test
    void Day07Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day07/day07_input.txt");
        assertTrue(result instanceof Integer, "Result should be an int");

        long actual = (Integer) result;
        int expectedLocationNumber = 251136060;
        assertEquals(expectedLocationNumber, actual);
    }

    @Test
    void Day07Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver02.solve("day07/day07_input.txt");
        assertTrue(result instanceof Integer, "Result should be an int");

        long actual = (Integer) result;
        int expectedLocationNumber = 249400220;
        assertEquals(expectedLocationNumber, actual);
    }
}
