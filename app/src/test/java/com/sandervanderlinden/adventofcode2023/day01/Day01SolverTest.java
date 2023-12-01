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
}
