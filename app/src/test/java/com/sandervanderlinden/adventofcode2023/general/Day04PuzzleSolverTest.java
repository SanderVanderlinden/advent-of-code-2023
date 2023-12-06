package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day04.Day04Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day04.Day04Puzzle02Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04PuzzleSolverTest {

    private final Day04Puzzle01Solver solver01 = new Day04Puzzle01Solver();
    private final Day04Puzzle02Solver solver02 = new Day04Puzzle02Solver();

    @Test
    void Day04Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve("day04/day04_input.txt");
        int expectedSum = 24175;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void Day04Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver02.solve("day04/day04_input.txt");
        int expectedSum = 18846301;
        assertEquals(expectedSum, actualSum);
    }

}
