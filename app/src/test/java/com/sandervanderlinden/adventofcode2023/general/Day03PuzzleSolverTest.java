package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03PuzzleSolverTest {

    private final Day03Puzzle01Solver solver01 = new Day03Puzzle01Solver();

    @Test
    void Day02Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve("day03/day03_input.txt");
        int expectedSum = 512794;
        assertEquals(expectedSum, actualSum);
    }
}
