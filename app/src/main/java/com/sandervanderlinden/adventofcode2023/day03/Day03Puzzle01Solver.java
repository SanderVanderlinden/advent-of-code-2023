package com.sandervanderlinden.adventofcode2023.day03;


import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Symbol;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solver for Day 3 Puzzle 1 of Advent of Code 2023.
 */
public class Day03Puzzle01Solver {

    private static final Logger logger = Logger.getLogger(Day03Puzzle01Solver.class.getName());

    private Set<SchematicToken> tokensInCurrentLine;

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day03Puzzle01Solver solver = new Day03Puzzle01Solver();
        int sum = solver.solve();
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    int solve() {
        return FileReaderUtil.processFile("/day03/day03_input.txt", this::solveLine);
    }

    private int solveLine(String line) {
        Set<SchematicToken> tokensInPreviousLine = tokensInCurrentLine;
        tokensInCurrentLine = convertLineToSchematicTokens(line);
        int sumNumbersInCurrentLineSymbolsInCurrentLine = sumNumbersInCurrentLineSymbolsInCurrentLine(tokensInCurrentLine);
        int sumNumbersInCurrentLineSymbolsInPreviousLine = sumNumbersInCurrentLineSymbolsInPreviousLine(tokensInPreviousLine, tokensInCurrentLine);
        int sumNumbersInPreviousLineSymbolsInCurrentLine = sumNumbersInPreviousLineSymbolsInCurrentLine(tokensInPreviousLine, tokensInCurrentLine);
        return sumNumbersInCurrentLineSymbolsInCurrentLine + sumNumbersInCurrentLineSymbolsInPreviousLine + sumNumbersInPreviousLineSymbolsInCurrentLine;
    }

    Set<SchematicToken> convertLineToSchematicTokens(String line) {
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
                    tokensInLine.add(new Symbol(i));
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

    private int sumNumbersInCurrentLineSymbolsInCurrentLine(Set<SchematicToken> tokensInCurrentLine) {
        return sumUncountedNumbersWithAdjacentSymbol(tokensInCurrentLine, number -> number.isAdjacentToSymbolInSameLine(tokensInCurrentLine));
    }

    private int sumNumbersInCurrentLineSymbolsInPreviousLine(Set<SchematicToken> tokensInPreviousLine, Set<SchematicToken> tokensInCurrentLine) {
        return sumUncountedNumbersWithAdjacentSymbol(tokensInCurrentLine, number -> number.isAdjacentToSymbolInOtherLine(tokensInPreviousLine));
    }

    private int sumNumbersInPreviousLineSymbolsInCurrentLine(Set<SchematicToken> tokensInPreviousLine, Set<SchematicToken> tokensInCurrentLine) {
        return sumUncountedNumbersWithAdjacentSymbol(tokensInPreviousLine, number -> number.isAdjacentToSymbolInOtherLine(tokensInCurrentLine));
    }

    private int sumUncountedNumbersWithAdjacentSymbol(Set<SchematicToken> targetTokens, Predicate<Number> adjacencyCheck) {
        int sum = 0;
        for (SchematicToken token : targetTokens) {
            if (token instanceof Number number && !number.isAlreadyCounted() && adjacencyCheck.test(number)) {
                number.setAlreadyCounted(true);
                sum += number.getValue();
            }
        }
        return sum;
    }

}
