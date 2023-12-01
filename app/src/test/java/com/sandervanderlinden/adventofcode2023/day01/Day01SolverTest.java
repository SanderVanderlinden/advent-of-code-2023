package com.sandervanderlinden.adventofcode2023.day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01SolverTest {

    private final Day01Solver solver = new Day01Solver();


    @Test
    void extractAndSumDigits_whenTypicalLine_shouldReturnSumOfFirstAndLastDigit() {
        String line = "example1line2";
        int expected = 12;
        assertEquals(expected, solver.extractAndSumDigits(line));
    }

    @Test
    void extractFirstDigit_whenTypicalLine_shouldReturnFirstDigit() {
        String line = "example1line2";
        int expected = 1;
        assertEquals(expected, solver.extractFirstDigit(line));
    }

    @Test
    void extractLastDigit_whenTypicalLine_shouldReturnLastDigit() {
        String line = "example1line2";
        int expected = 2;
        assertEquals(expected, solver.extractLastDigit(line));
    }
}
