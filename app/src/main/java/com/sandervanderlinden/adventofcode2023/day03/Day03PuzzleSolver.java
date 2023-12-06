package com.sandervanderlinden.adventofcode2023.day03;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day03.schematic.GearSymbol;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Symbol;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class for Day 3 puzzles in Advent of Code 2023.
 * This class offers a foundational framework for puzzles that involve interpreting
 * and processing schematic data. It provides utility methods to convert input lines
 * into sets of schematic tokens, supporting the creation of solutions for Day 3 challenges.
 */
public abstract class Day03PuzzleSolver implements BasePuzzleSolver {

    /**
     * Converts a line of input text into a set of schematic tokens.
     * This method parses each character in the input line, distinguishing between
     * digits (which form numbers) and non-digit characters (which are treated as symbols).
     * It is essential for parsing the puzzle input and preparing it for further processing.
     *
     * @param line The input line to be converted into tokens.
     * @return A set of {@link SchematicToken} objects representing the identified numbers and symbols.
     */
    public Set<SchematicToken> convertLineToSchematicTokens(String line) {
        Set<SchematicToken> tokensInLine = new HashSet<>();
        StringBuilder currentNumber = new StringBuilder();
        int numberPositionIndex = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isDigit(c)) {
                if (currentNumber.isEmpty()) {
                    numberPositionIndex = i;
                }
                currentNumber.append(c);
            }
            else {
                handleNonDigitCharacter(tokensInLine, currentNumber, numberPositionIndex, i, c);
                currentNumber.setLength(0);
            }
        }

        addRemainingNumberToken(tokensInLine, currentNumber, numberPositionIndex);

        return tokensInLine;
    }

    /**
     * Handles non-digit characters in the input line, adding the appropriate symbol tokens
     * to the set of schematic tokens. Also adds any accumulated number token before processing
     * the symbol.
     *
     * @param tokens The set of schematic tokens being constructed.
     * @param currentNumber The currently accumulated number, if any.
     * @param numberPositionIndex The starting index of the current number in the input line.
     * @param currentIndex The index of the current non-digit character being processed.
     * @param c The current non-digit character.
     */
    private static void handleNonDigitCharacter(Set<SchematicToken> tokens, StringBuilder currentNumber, int numberPositionIndex, int currentIndex, char c) {
        if (c != '.') {
            tokens.add(c == '*' ? new GearSymbol(currentIndex) : new Symbol(currentIndex));
        }

        if (currentNumber.length() > 0) {
            tokens.add(new Number(numberPositionIndex, Integer.parseInt(currentNumber.toString())));
        }

    }

    /**
     * Adds the last accumulated number token to the set of schematic tokens, if any.
     * This method is called after the end of input line processing to ensure that any
     * remaining number is not left out.
     *
     * @param tokensInLine The set of schematic tokens being constructed.
     * @param currentNumber The currently accumulated number, if any.
     * @param numberPositionIndex The starting index of the current number in the input line.
     */
    private static void addRemainingNumberToken(Set<SchematicToken> tokensInLine, StringBuilder currentNumber, int numberPositionIndex) {
        if (currentNumber.length() > 0) {
            tokensInLine.add(new Number(numberPositionIndex, Integer.parseInt(currentNumber.toString())));
        }
    }



}
