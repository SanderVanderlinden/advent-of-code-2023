package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day08.Day08Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day08PuzzleSolverTest {

    private final Day08Puzzle01Solver solver01 = new Day08Puzzle01Solver();

    @Test
    void Day08Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        Object result = solver01.solve("day08/day08_input.txt");
        assertTrue(result instanceof Integer, "Result should be an int");

        long actual = (Integer) result;
        int expectedLocationNumber = 18157;
        assertEquals(expectedLocationNumber, actual);
    }
}
