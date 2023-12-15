package com.sandervanderlinden.adventofcode2023.day03.schematic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NumberTest {

    static Set<SchematicToken> setContainingEverything = createSetForLineContainingEverything();

    static Stream<Arguments> isAdjacentToSymbolInSameLineArguments() {
        return Stream.of(
                // Scenario: Empty symbol set in the same line, expect no adjacent symbol for a single digit number
                Arguments.of(createEmptySchematicTokenSet(), createSingleDigitNumberWithNoAdjacentTokens(), false),

                // Scenario: No adjacent symbols in the same line, expect false for a single digit number
                Arguments.of(setContainingEverything, createSingleDigitNumberWithNoAdjacentTokens(), false),

                // Scenario: A symbol is adjacent destination the left of a single digit number in the same line, expect true
                Arguments.of(setContainingEverything, createSingleDigitNumberWithAdjacentTokenToTheLeft(), true),

                // Scenario: A symbol is adjacent destination the right of a single digit number in the same line, expect true
                Arguments.of(setContainingEverything, createSingleDigitNumberWithAdjacentTokenToTheRight(), true),

                // Scenario: No adjacent symbols in the same line, expect false for a multiple digit number
                Arguments.of(setContainingEverything, createMultipleDigitsNumberWithNoAdjacentTokens(), false),

                // Scenario: A symbol is adjacent destination the left of a multiple digit number in the same line, expect true
                Arguments.of(setContainingEverything, createMultipleDigitsWithAdjacentTokenToTheLeft(), true),

                // Scenario: A symbol is adjacent destination the right of a multiple digit number in the same line, expect true
                Arguments.of(setContainingEverything, createMultipleDigitsWithAdjacentTokenToTheRight(), true)
        );
    }

    static Stream<Arguments> isAdjacentToSymbolInOtherLineArguments() {
        return Stream.of(
                // Scenario: Empty symbol set in the other line
                Arguments.of(createEmptySchematicTokenSet(), createSingleDigitNumberWithNoAdjacentTokens(), false),

                // Scenario: No adjacent symbols in the other line
                Arguments.of(setContainingEverything, createSingleDigitNumberWithNoAdjacentTokens(), false),

                // Scenario: Adjacent symbol destination the left in the other line
                Arguments.of(setContainingEverything, createSingleDigitNumberWithAdjacentTokenToTheLeft(), true),

                // Scenario: Adjacent symbol on the same index in the other line
                Arguments.of(setContainingEverything, createSingleDigitNumberWithAdjacentTokenOnTheSameIndex(), true),

                // Scenario: Adjacent symbol destination the right in the other line
                Arguments.of(setContainingEverything, createSingleDigitNumberWithAdjacentTokenToTheRight(), true),

                // Scenario: Multiple digits number with no adjacent symbols in the other line
                Arguments.of(setContainingEverything, createMultipleDigitsNumberWithNoAdjacentTokens(), false),

                // Scenario: Multiple digits number with an adjacent symbols destination the left in the other line
                Arguments.of(setContainingEverything, createMultipleDigitsWithAdjacentTokenToTheLeft(), true),

                // Scenario: Multiple digits number with digit on the same index as a symbol in the other line
                Arguments.of(setContainingEverything, createMultipleDigitsNumberWithAdjacentTokenOnTheSameIndex(), true),

                // Scenario: Multiple digits number with an adjacent symbol destination the right in the other line
                Arguments.of(setContainingEverything, createMultipleDigitsWithAdjacentTokenToTheRight(), true)
        );
    }

    @ParameterizedTest(name = "{0} and {1} should return {2}")
    @MethodSource("isAdjacentToSymbolInSameLineArguments")
    void testIsAdjacentToSymbolInSameLine(Set<SchematicToken> tokensInCurrentLine, Number number, boolean expected) {
        assertEquals(expected, number.isAdjacentToSymbolInSameLine(tokensInCurrentLine));
    }

    @ParameterizedTest(name = "{0} and {1} should return {2}")
    @MethodSource("isAdjacentToSymbolInOtherLineArguments")
    void isAdjacentToSymbolInOtherLine(Set<SchematicToken> tokensInOtherLine, Number number, boolean expected) {
        assertEquals(expected, number.isAdjacentToSymbolInOtherLine(tokensInOtherLine));
    }

    @Test
    void testEquals() {
        Number number1 = new Number(1, 10);
        Number number2 = new Number(1, 10);
        Number numberDifferentValue = new Number(1, 20);
        Number numberDifferentPosition = new Number(2, 10);

        assertEquals(number1, number1); // Same object
        assertEquals(number1, number2); // Different objects, same state
        assertNotEquals(number1, numberDifferentValue); // Different value
        assertNotEquals(number1, numberDifferentPosition); // Different position
        assertNotEquals(null, number1); // Comparison with null
        assertNotEquals(number1, new Object()); // Different class type
    }
}