package com.sandervanderlinden.adventofcode2023.general;

import com.sandervanderlinden.adventofcode2023.day01.Day01Puzzle01Solver;
import com.sandervanderlinden.adventofcode2023.day01.Day01Puzzle02Solver;
import com.sandervanderlinden.adventofcode2023.day01.Day01PuzzleSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class Day01PuzzleSolverTest {

    private static final String inputFilePath = "/day01/day01_input.txt";
    private final Day01PuzzleSolver solver01 = new Day01Puzzle01Solver();
    private final Day01PuzzleSolver solver02 = new Day01Puzzle02Solver();

    @Test
    void Day01Puzzle01Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver01.solve(inputFilePath);
        int expectedSum = 54644; // The expected sum for Puzzle 1
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void Day01Puzzle02Solver_whenGivenAdventOfCodeProblem_shouldReturnCorrectSolution() {
        int actualSum = solver02.solve(inputFilePath);
        int expectedSum = 53348; // The expected sum for Puzzle 2
        assertEquals(expectedSum, actualSum);
    }
}
