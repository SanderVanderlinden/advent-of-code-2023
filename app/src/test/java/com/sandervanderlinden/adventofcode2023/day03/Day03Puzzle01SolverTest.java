package com.sandervanderlinden.adventofcode2023.day03;

import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Day03Puzzle01Solver.
 * Contains various test cases to verify the functionality of the puzzle solver for Day 3 Puzzle 1.
 */
class Day03Puzzle01SolverTest {

    Day03Puzzle01Solver solver = new Day03Puzzle01Solver();

    static Stream<Arguments> testConvertLineToSchematicTokensArguments() {
        return Stream.of(
                //convertLineToSchematic_whenEmptyLine_shouldReturnEmptySet
                Arguments.of("", createEmptySchematicTokenSet()),

                //convertLineToSchematic_whenLineContainingOnlyPointCharacters_shouldReturnEmptySet
                Arguments.of("..........................", createEmptySchematicTokenSet()),

                //convertLineToSchematic_whenLineContainingSymbols_shouldReturnSetWithTheseSymbols
                Arguments.of(lineContainingSymbols(), createSetForLineContainingSymbols()),

                //convertLineToSchematic_whenLineContainingSeparatedDigits_shouldReturnSetWithTheseNumbers
                Arguments.of(lineContainingDigits(), createSetForLineContainingDigits()),

                //convertLineToSchematic_whenLineContainingNumbers_shouldReturnSetWithTheseNumbers
                Arguments.of(lineContainingNumbers(), createSetForLineContainingNumbers()),

                //convertLineToSchematic_whenLineContainingEverything_shouldReturnSetWithTheseNumbersAndSymbols
                Arguments.of(lineContainingEverything(), createSetForLineContainingEverything())
        );
    }

    /**
     * Tests the conversion of a line to schematic tokens.
     */
    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testConvertLineToSchematicTokensArguments")
    void testConvertLineToSchematicTokens(String line, Set<SchematicToken> expected) {
        assertEquals(expected, solver.convertLineToSchematicTokens(line));
    }

    @Test
    void sumNumbersInCurrentLineSymbolsInCurrentLine_whenAllNumbersNotCounted_returnCorrectSum() {
        int expected = 5136;
        assertEquals(expected, solver.sumNumbersInCurrentLineSymbolsInCurrentLine(createSetForLineContainingEverything()));
    }

    @Test
    void sumNumbersInCurrentLineSymbolsInCurrentLine_whenSomeNumbersAlreadyCounted_returnCorrectSum() {
        Set<SchematicToken> tokens = createSetForLineContainingEverything();
        tokens.stream()
                .filter(token -> token instanceof Number && token.getPositionIndex() == 8)
                .map(token -> (Number) token)
                .findFirst()
                .ifPresent(number -> number.setAlreadyCounted(true));

        int expected = 348;
        assertEquals(expected, solver.sumNumbersInCurrentLineSymbolsInCurrentLine(tokens));
    }


    @Test
    void testSolve() {
        int expected = 110101;
        String filepath = "day03/day03_test_input_01.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }

    @Test
    void testSolve02() {
        int expected = 4361;
        String filepath = "day03/day03_test_input_02.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }

}