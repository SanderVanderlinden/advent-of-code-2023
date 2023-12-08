package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day01.util.TestUtil.*;
import static com.sandervanderlinden.adventofcode2023.day01.util.TestUtil.linePresentingLettersAndExactlyOneDigit_DigitIs2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Abstract base class for testing Day 1 puzzle solvers.
 * Defines common test cases and requires subclasses to provide the specific solver implementation.
 */
public abstract class Day01PuzzleSolverTest {

    protected abstract Day01PuzzleSolver getSolver();
    Day01PuzzleSolver solver = getSolver();


    @Test
    void extractValueFromLine_whenTypicalLine_shouldReturnSumOfFirstAndLastDigit() {
        String line = linePresentingLettersAndDigits_FirstDigitIs1_LastDigitIs2();
        int expected = 12;
        assertEquals(expected, solver.extractValueFromLine(line));
    }

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testExtractFirstDigitArguments")
    void testExtractFirstDigit(String line, int expected) {
        assertEquals(expected, solver.extractFirstDigit(line));

    }

    static Stream<Arguments> testExtractFirstDigitArguments() {
        return Stream.of(
                //extractFirstDigit_whenLotsOfDigitsInLine_shouldReturnFirstDigit
                Arguments.of(linePresentingLettersAndDigits_FirstDigitIs1_LastDigitIs2(), 1),

                //extractFirstDigit_whenOnlyOneDigitInLine_shouldReturnDigit
                Arguments.of(linePresentingManyLettersAndDigits_FirstDigitIs8_LastDigitIs7(), 8),

                //extractFirstDigit_whenNoDigitsInLine_throwError
                Arguments.of(linePresentingLettersAndExactlyOneDigit_DigitIs2(), 2)
        );
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

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testExtractLastDigitArguments")
    void testExtractLastDigit(String line, int expected) {
        assertEquals(expected, solver.extractLastDigit(line));

    }

    static Stream<Arguments> testExtractLastDigitArguments() {
        return Stream.of(
                //extractLastDigit_whenTypicalLine_shouldReturnLastDigit
                Arguments.of(linePresentingLettersAndDigits_FirstDigitIs1_LastDigitIs2(), 2),

                //extractLastDigit_whenOnlyOneDigitInLine_shouldReturnDigit
                Arguments.of(linePresentingManyLettersAndDigits_FirstDigitIs8_LastDigitIs7(), 7),

                //extractFirstDigit_whenNoDigitsInLine_throwError
                Arguments.of(linePresentingLettersAndExactlyOneDigit_DigitIs2(), 2)
        );
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