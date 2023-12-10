package com.sandervanderlinden.adventofcode2023.day03;


import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * Solver for Day 3 Puzzle 1 of Advent of Code 2023.
 * This class processes schematic data represented as tokens and calculates specific values based on these tokens.
 * It is responsible for interpreting input lines into tokens and summing up values according to puzzle rules.
 */
public class Day03Puzzle01Solver extends Day03PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day03Puzzle01Solver.class.getName());

    private Set<SchematicToken> tokensInCurrentLine = new HashSet<>();

    /**
     * Main method to execute the solver.
     */
    public static void main(String[] args) {
        Day03PuzzleSolver solver = new Day03Puzzle01Solver();
        String filePath = "day03/day03_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }

    /**
     * Processes an individual line of the puzzle input by converting it into schematic tokens.
     * It calculates the sum of numbers adjacent to certain symbols in the current line, the previous line,
     * and the combination of both, according to the puzzle's rules.
     *
     * @param line The input line from the puzzle to be processed.
     * @return The sum of values as per the puzzle's logic.
     */
    @Override
    public int extractValueFromLine(String line) {
        Set<SchematicToken> tokensInPreviousLine = tokensInCurrentLine;
        tokensInCurrentLine = convertLineToSchematicTokens(line);
        int sumNumbersInCurrentLineSymbolsInCurrentLine = sumNumbersInCurrentLineSymbolsInCurrentLine(tokensInCurrentLine);
        int sumNumbersInCurrentLineSymbolsInPreviousLine = sumNumbersInCurrentLineSymbolsInPreviousLine(tokensInPreviousLine, tokensInCurrentLine);
        int sumNumbersInPreviousLineSymbolsInCurrentLine = sumNumbersInPreviousLineSymbolsInCurrentLine(tokensInPreviousLine, tokensInCurrentLine);
        return sumNumbersInCurrentLineSymbolsInCurrentLine + sumNumbersInCurrentLineSymbolsInPreviousLine + sumNumbersInPreviousLineSymbolsInCurrentLine;
    }

    int sumNumbersInCurrentLineSymbolsInCurrentLine(Set<SchematicToken> tokensInCurrentLine) {
        return sumUncountedNumbersWithAdjacentSymbol(tokensInCurrentLine, number -> number.isAdjacentToSymbolInSameLine(tokensInCurrentLine));
    }

    int sumNumbersInCurrentLineSymbolsInPreviousLine(Set<SchematicToken> tokensInPreviousLine, Set<SchematicToken> tokensInCurrentLine) {
        return sumUncountedNumbersWithAdjacentSymbol(tokensInCurrentLine, number -> number.isAdjacentToSymbolInOtherLine(tokensInPreviousLine));
    }

    int sumNumbersInPreviousLineSymbolsInCurrentLine(Set<SchematicToken> tokensInPreviousLine, Set<SchematicToken> tokensInCurrentLine) {
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
