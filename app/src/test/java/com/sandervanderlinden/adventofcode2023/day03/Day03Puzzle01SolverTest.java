package com.sandervanderlinden.adventofcode2023.day03;

import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testConvertLineToSchematicTokensArguments")
    void testConvertLineToSchematicTokens(String line, Set<SchematicToken> expected) {
        assertEquals(expected, solver.convertLineToSchematicTokens(line));
    }
}