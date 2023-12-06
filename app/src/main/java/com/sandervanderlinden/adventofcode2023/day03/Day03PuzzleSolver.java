package com.sandervanderlinden.adventofcode2023.day03;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day03.schematic.GearSymbol;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Symbol;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class for solving Day 3 puzzles of Advent of Code 2023.
 * This class provides a common foundation and utilities for solving puzzles that involve
 * interpreting and processing schematic data. It defines methods that are common across
 * various Day 3 puzzle solvers, such as converting input lines into sets of schematic tokens.
 */
public abstract class Day03PuzzleSolver implements BasePuzzleSolver {

    /**
     * Converts a line of input text into a set of schematic tokens. Each token can represent
     * either a number or a symbol based on the content of the line. Numbers are identified
     * from sequences of digit characters, while symbols are identified from specific non-digit
     * characters. This method is essential for parsing and processing the puzzle input.
     *
     * @param line The input line to be converted into tokens. It is a string that potentially
     *             contains numbers, symbols, and other characters.
     * @return A set of {@link SchematicToken} objects, each representing either a number or a symbol
     * found in the input line. The set includes all identified tokens from the line.
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
                if (c != '.') {
                    if (c == '*') {
                        tokensInLine.add(new GearSymbol(i));
                    }
                    else {
                        tokensInLine.add(new Symbol(i));
                    }
                }
                if (!currentNumber.isEmpty()) {
                    tokensInLine.add(new Number(numberPositionIndex, Integer.parseInt(currentNumber.toString())));
                    currentNumber.setLength(0);
                }
            }
        }

        if (currentNumber.length() > 0) {
            tokensInLine.add(new Number(numberPositionIndex, Integer.parseInt(currentNumber.toString())));
        }

        return tokensInLine;
    }


}
