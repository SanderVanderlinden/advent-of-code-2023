package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void extractFirstDigit_whenLotsOfDigitsInLine_shouldReturnFirstDigit() {
        String line = "82e564xa546m654p23l56e1l85764i87641n57e36927";
        int expected = 8;
        assertEquals(expected, solver.extractFirstDigit(line));
    }

    @Test
    void extractFirstDigit_whenOnlyOneDigitInLine_shouldReturnDigit() {
        String line = "example2line";
        int expected = 2;
        assertEquals(expected, solver.extractFirstDigit(line));
    }


    @Test
    void extractFirstDigit_whenNoDigitsInLine_throwError() {
        String line = "example";
        assertThrows(NoDigitFoundException.class, () -> solver.extractFirstDigit(line));

    }


    @Test
    void extractLastDigit_whenTypicalLine_shouldReturnLastDigit() {
        String line = "example1line2";
        int expected = 2;
        assertEquals(expected, solver.extractLastDigit(line));
    }

    @Test
    void extractLastDigit_whenLotsOfDigitsInLine_shouldReturnLastDigit() {
        String line = "8e564xa546m654p23l56e1l85764i87641n57e36927";
        int expected = 7;
        assertEquals(expected, solver.extractLastDigit(line));
    }

    @Test
    void extractLastDigit_whenOnlyOneDigitInLine_shouldReturnDigit() {
        String line = "example2line";
        int expected = 2;
        assertEquals(expected, solver.extractLastDigit(line));
    }


    @Test
    void extractLastDigit_whenNoDigitsInLine_throwError() {
        String line = "example";
        assertThrows(NoDigitFoundException.class, () -> solver.extractLastDigit(line));

    }
}
