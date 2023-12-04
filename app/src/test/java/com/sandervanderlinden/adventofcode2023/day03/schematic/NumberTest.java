package com.sandervanderlinden.adventofcode2023.day03.schematic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTest {

    static Stream<Arguments> isAdjacentToSymbolInSameLineArguments() {
        return Stream.of(
                //isAdjacentToSymbolInSameLine_whenEmptyTokenSet_shouldReturnFalse
                Arguments.of(createEmptySchematicTokenSet(), createSingleDigitNumberWithNoAdjacentTokens(), false),
                //isAdjacentToSymbolInSameLine_whenNoAdjacentTokensAndSingleDigit_shouldReturnFalse
                Arguments.of(createSetForLineContainingEverything(), createSingleDigitNumberWithNoAdjacentTokens(), false),
                //isAdjacentToSymbolInSameLine_whenAdjacentTokenToTheLeftAndSingleDigit_shouldReturnTrue
                Arguments.of(createSetForLineContainingEverything(), createSingleDigitNumberWithAdjacentTokenToTheLeft(), true),
                //isAdjacentToSymbolInSameLine_whenAdjacentTokenToTheRightAndSingleDigit_shouldReturnTrue
                Arguments.of(createSetForLineContainingEverything(), createSingleDigitNumberWithAdjacentTokenToTheRight(), true),
                //isAdjacentToSymbolInSameLine_whenNoAdjacentTokensAndMultipleDigits_shouldReturnFalse
                Arguments.of(createSetForLineContainingEverything(), createMultipleDigitsNumberWithNoAdjacentTokens(), false),
                //isAdjacentToSymbolInSameLine_whenAdjacentTokenToTheLeftAndMultipleDigits_shouldReturnTrue
                Arguments.of(createSetForLineContainingEverything(), createMultipleDigitsWithAdjacentTokenToTheLeft(), true),
                //isAdjacentToSymbolInSameLine_whenAdjacentTokenToTheRightAndMultipleDigits_shouldReturnTrue
                Arguments.of(createSetForLineContainingEverything(), createMultipleDigitsWithAdjacentTokenToTheRight(), true)

        );
    }

    @ParameterizedTest(name = "{0} and {1} should return {2}")
    @MethodSource("isAdjacentToSymbolInSameLineArguments")
    void testIsAdjacentToSymbolInSameLine(Set<SchematicToken> tokensInCurrentLine, Number number, boolean expected) {
        assertEquals(expected, number.isAdjacentToSymbolInSameLine(tokensInCurrentLine));
    }


//TODO
//    @Test
//    void isAdjacentToSymbolInOtherLine() {
//    }
}