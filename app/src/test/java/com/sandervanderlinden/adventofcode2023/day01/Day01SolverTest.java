package com.sandervanderlinden.adventofcode2023.day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01SolverTest {

    @Test
    void extractAndSumNumbers_ShouldReturnSumOfFirstAndLastDigit() {
        Day01Solver solver = new Day01Solver();
        String line = "example1line2";
        int expected = 12;
        assertEquals(expected, solver.extractAndSumNumbers(line));
    }

    @Test
    void extractFirstNumber() {
        Day01Solver solver = new Day01Solver();
        String line = "example1line2";
        int expected = 1;
        assertEquals(expected, solver.extractFirstNumber(line));
    }

    @Test
    void extractLastNumber() {
        Day01Solver solver = new Day01Solver();
        String line = "example1line2";
        int expected = 2;
        assertEquals(expected, solver.extractLastNumber(line));
    }
}
