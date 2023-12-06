package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03PuzzleSolverTest {

    private final Day03Puzzle01Solver solver01 = new Day03Puzzle01Solver();
    private final Day03Puzzle02Solver solver02 = new Day03Puzzle02Solver();

    @Test
    void Day03Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve("day03/day03_input.txt");
        int expectedSum = 512794;
        assertEquals(expectedSum, actualSum);
    }
    @Test
    void Day03Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver02.solve("day03/day03_input.txt");
        int expectedSum = 67779080;
        assertEquals(expectedSum, actualSum);
    }
}
