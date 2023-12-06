package com.sandervanderlinden.adventofcode2023.day03;


import com.sandervanderlinden.adventofcode2023.day03.schematic.GearSymbol;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solver for Day 3 Puzzle 2 of Advent of Code 2023.
 * This class extends the functionality of Day03PuzzleSolver to process input lines of schematic data.
 * It interprets these lines as tokens and performs specific calculations to solve Puzzle 2.
 * The primary operation involves checking for gears and summing their ratios as per the puzzle's rules.
 */
public class Day03Puzzle02Solver extends Day03PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day03Puzzle02Solver.class.getName());

    private Set<SchematicToken> tokensInCurrentLine = new HashSet<>();

    /**
     * Executes the puzzle solver. This is the main entry point for solving Puzzle 2 of Day 3.
     * It reads the puzzle input from a file, processes each line, and calculates the final sum.
     */
    public static void main(String[] args) {
        Day03Puzzle02Solver solver = new Day03Puzzle02Solver();
        int sum = solver.solve("day03/day03_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    /**
     * Processes the puzzle input file and sums up the gear ratios from the last line of tokens.
     * This method extends the base solve method by adding an additional step of summing gear ratios.
     *
     * @param filePath The path to the input file containing the puzzle data.
     * @return The total sum of the calculated values, including the gear ratios from the last line.
     */
    @Override
    public int solve(String filePath) {
        return FileReaderUtil.processFile(filePath, this::processLine) + sumGearRatios(tokensInCurrentLine);
    }

    /**
     * Processes a single line of input by converting it into schematic tokens.
     * It checks for gears in the current and previous lines and sums their ratios.
     *
     * @param line The line from the puzzle input to be processed.
     * @return The sum of gear ratios for the processed line.
     */
    @Override
    public int processLine(String line) {
        Set<SchematicToken> tokensInPreviousLine = tokensInCurrentLine;
        tokensInCurrentLine = convertLineToSchematicTokens(line);
        checkForGears(tokensInPreviousLine, tokensInCurrentLine);
        return sumGearRatios(tokensInPreviousLine);
    }

    private void checkForGears(Set<SchematicToken> tokensInPreviousLine, Set<SchematicToken> tokensInCurrentLine) {
        processTokens(tokensInCurrentLine, tokensInCurrentLine);
        processTokens(tokensInPreviousLine, tokensInCurrentLine);
        processTokens(tokensInCurrentLine, tokensInPreviousLine);
    }

    private void processTokens(Set<SchematicToken> sourceTokens, Set<SchematicToken> targetTokens) {
        for (SchematicToken token : sourceTokens) {
            if (token instanceof Number number) {
                number.addToAdjacentGearSymbols(targetTokens);
            }
        }
    }

    int sumGearRatios(Set<SchematicToken> targetTokens) {
        int sum = 0;
        for (SchematicToken token : targetTokens) {
            if (token instanceof GearSymbol gearSymbol && gearSymbol.isGear()) {
                sum += gearSymbol.getRatio();
            }
        }
        return sum;
    }

}
