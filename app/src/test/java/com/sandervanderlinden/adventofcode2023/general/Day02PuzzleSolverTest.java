package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day02.Day02Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02PuzzleSolverTest {

    private final Day02Puzzle01Solver solver01 = new Day02Puzzle01Solver();

    @Test
    void Day01Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve();
        int expectedSum = 2369;
        assertEquals(expectedSum, actualSum);
    }
}
