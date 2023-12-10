package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Game;

import java.util.logging.Logger;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * Solver for Day 2 Puzzle 1 of Advent of Code 2023.
 * This solver processes game data to determine which games are possible
 * given specific constraints on the number of cubes.
 */
public class Day02Puzzle01Solver extends Day02PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day02Puzzle01Solver.class.getName());


    /**
     * Main method to execute the solver.
     * Processes the input file and calculates the total sum of the IDs of possible games.
     */
    public static void main(String[] args) {
        Day02PuzzleSolver solver = new Day02Puzzle01Solver();
        String filePath = "day02/day02_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }


    /**
     * Determines the ID value of a game based on its possibility.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The ID of the game if it is possible, or 0 otherwise.
     */
    @Override
    public int extractValueFromLine(String line) {
        Game game = createGameFromLine(line);
        if (game.isPossible()) {
            return game.getId();
        }
        return 0;
    }
}
