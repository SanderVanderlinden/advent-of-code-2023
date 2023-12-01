package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day01Puzzle01SolverTest {

    private final Day01Puzzle01Solver solver = new Day01Puzzle01Solver();


    @Test
    void extractAndCombineDigits_whenTypicalLine_shouldReturnSumOfFirstAndLastDigit() {
        String line = "example9line2";
        int expected = 92;
        assertEquals(expected, solver.extractAndCombineDigits(line));
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
    void extractFirstDigit_whenEmptyLine_throwError() {
        String line = "";
        assertThrows(NoDigitFoundException.class, () -> solver.extractFirstDigit(line));
    }

    @Test
    void extractFirstDigit_whenNullLine_throwError() {
        assertThrows(NullPointerException.class, () -> solver.extractFirstDigit(null));
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

    @Test
    void extractLastDigit_whenEmptyLine_throwError() {
        String line = "";
        assertThrows(NoDigitFoundException.class, () -> solver.extractLastDigit(line));
    }

    @Test
    void extractLastDigit_whenNullLine_throwError() {
        assertThrows(NullPointerException.class, () -> solver.extractLastDigit(null));
    }
}
