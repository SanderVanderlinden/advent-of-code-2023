package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day04.Day04Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04PuzzleSolverTest {

    private final Day04Puzzle01Solver solver01 = new Day04Puzzle01Solver();

    @Test
    void Day03Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve("day04/day04_input.txt");
        int expectedSum = 24175;
        assertEquals(expectedSum, actualSum);
    }

}
