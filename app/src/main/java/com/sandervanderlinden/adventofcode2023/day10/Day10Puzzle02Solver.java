package com.sandervanderlinden.adventofcode2023.day10;

import com.sandervanderlinden.adventofcode2023.day10.pipe.PipeForm;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the second puzzle of Day 10 in the Advent of Code 2023.
 */
public class Day10Puzzle02Solver extends Day10PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day10Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day10Puzzle02Solver solver = new Day10Puzzle02Solver();
        String filePath = "day10/day10_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    Object solution() {
        //jf of 7l telt maar als 1. 7j telt dan wel weer als 2
        //voor elke f moet er een l of een j volgen ergens
        long areaSize = 0;
        for (int x = 0; x < pipeGrid.length; x++) {
            int totalAmountOfHorizontalPipes = getAmountOfHorizontalPipes(x, pipeGrid[x].length);
            for (int y = 0; y < pipeGrid[x].length; y++) {
                if (pipeGrid[x][y] == null) {
                    int currentAmountOfHorizontalPipes = getAmountOfHorizontalPipes(x, y);
                    if (isOdd(currentAmountOfHorizontalPipes) && isEven(totalAmountOfHorizontalPipes)) {
                        areaSize++;
                    }
                }
            }
        }
        return areaSize;
    }

    int getAmountOfHorizontalPipes(int x, int lineLength) {
        int totalPartsOfLoopInCurrentLine = 0;
        PipeForm previousPipeForm = null;

        for (int y = 0; y < lineLength; y++) {
            if (pipeGrid[x][y] != null) {
                PipeForm currentPipeForm = pipeGrid[x][y].getPipeForm();
                if (currentPipeForm == PipeForm.HORIZONTAL) {
                    totalPartsOfLoopInCurrentLine++;
                }
                else if (currentPipeForm != PipeForm.VERTICAL) {
                    totalPartsOfLoopInCurrentLine += calculateLoopPart(previousPipeForm, currentPipeForm, x, y);
                    previousPipeForm = (previousPipeForm == null) ? currentPipeForm : null;
                }
            }
        }
        return totalPartsOfLoopInCurrentLine;
    }

    private int calculateLoopPart(PipeForm previousPipeForm, PipeForm currentPipeForm, int x, int y) {
        if (previousPipeForm == null) {
            return 0;
        }
        else {
            return switch (previousPipeForm) {
                case SOUTHEAST -> currentPipeForm == PipeForm.NORTHEAST ? 2 : 1;
                case SOUTHWEST -> currentPipeForm == PipeForm.NORTHWEST ? 2 : 1;
                default ->
                        throw new IllegalStateException("Unexpected value: " + previousPipeForm + " at x: " + x + ", y: " + y);
            };
        }
    }

    private boolean isEven(double number) {
        return number % 2 == 0;
    }

    private boolean isOdd(double number) {
        return !isEven(number);
    }
}