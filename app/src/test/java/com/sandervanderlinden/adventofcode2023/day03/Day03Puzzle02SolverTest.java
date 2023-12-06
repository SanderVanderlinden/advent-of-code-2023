package com.sandervanderlinden.adventofcode2023.day03;

import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for Day03Puzzle02Solver.
 * Contains various test cases to verify the functionality of the puzzle solver for Day 3 Puzzle 1.
 */
class Day03Puzzle02SolverTest {

    Day03Puzzle02Solver solver = new Day03Puzzle02Solver();

    static Stream<Arguments> testSumGearRatiosArguments() {
        return Stream.of(
                // Scenario: Empty SchematicToken set
                Arguments.of(createEmptySchematicTokenSet(), 0),

                // Scenario: set contains 3 GearSymbols, 2 of those are gears
                Arguments.of(createSetWithSomeGearSymbols(), 276)

        );
    }

    @Test
    void testConvertLineToSchematicTokens() {
        assertEquals(createSetForLineContainingGears(), solver.convertLineToSchematicTokens(lineContainingGears()));
    }

    @Test
    void testConvertLineToSchematicTokensWithSchematicTokens() {
        Set<SchematicToken> expected = createSetForLineContainingGears();

        Set<SchematicToken> actual = solver.convertLineToSchematicTokens(lineContainingGears());
        solver.processTokens(actual);
        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected.size(), actual.size(), "Sets should be the same size");

        for (SchematicToken expectedToken : expected) {
            assertTrue(actual.contains(expectedToken), "Actual set should contain: " + expectedToken);
        }
    }

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testSumGearRatiosArguments")
    void testSumGearRatios(Set<SchematicToken> schematicTokens, int expected) {
        assertEquals(expected, solver.sumGearRatios(schematicTokens));
    }

    @Test
    void testSolve() {
        int expected = 467835;
        String filepath = "day03/day03_test_input_02.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }

}