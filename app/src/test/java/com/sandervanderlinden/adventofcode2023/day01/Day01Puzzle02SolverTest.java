package com.sandervanderlinden.adventofcode2023.day01;

import org.junit.jupiter.api.Test;

import static com.sandervanderlinden.adventofcode2023.day01.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Day01Puzzle02Solver.
 * Contains various test cases to verify the functionality of the puzzle solver for the second puzzle of Day 1.
 */
class Day01Puzzle02SolverTest extends Day01PuzzleSolverTest {

    @Override
    protected Day01PuzzleSolver getSolver() {
        return new Day01Puzzle02Solver();
    }

    @Test
    void extractFirstDigit_whenLineWithTextDigits_shouldReturnFirstDigit() {
        String line = linePresentingSpelledLettersAndDigits_FirstDigitIs2_LastDigitIs9();
        int expected = 2;
        assertEquals(expected, solver.extractFirstDigit(line));
    }

    @Test
    void extractFirstDigit_whenLineWithTextDigitsAndRegularDigits_shouldReturnFirstDigit() {
        String line = linePresentingSpelledLettersAndDigits_FirstDigitIs1_LastDigitIs4();
        int expected = 1;
        assertEquals(expected, solver.extractFirstDigit(line));
    }

    @Test
    void extractFirstDigit_whenLineWithOverlappingTextDigits_shouldReturnFirstDigit() {
        String line = linePresentingSpelledOverlappingTextDigits_FirstDigitIs1_LastDigitIs8();
        int expected = 1;
        assertEquals(expected, solver.extractFirstDigit(line));
    }

    @Test
    void extractLastDigit_whenLineWithTextDigits_shouldReturnLastDigit() {
        String line = linePresentingSpelledLettersAndDigits_FirstDigitIs2_LastDigitIs9();
        int expected = 9;
        assertEquals(expected, solver.extractLastDigit(line));
    }

    @Test
    void extractLastDigit_whenLineWithTextDigitsAndRegularDigits_shouldReturnLastDigit() {
        String line = linePresentingSpelledLettersAndDigits_FirstDigitIs1_LastDigitIs4();
        int expected = 4;
        assertEquals(expected, solver.extractLastDigit(line));
    }

    @Test
    void extractLastDigit_whenLineWithOverlappingTextDigits_shouldReturnLastDigit() {
        String line = linePresentingSpelledOverlappingTextDigits_FirstDigitIs1_LastDigitIs8();
        int expected = 8;
        assertEquals(expected, solver.extractLastDigit(line));
    }

}
