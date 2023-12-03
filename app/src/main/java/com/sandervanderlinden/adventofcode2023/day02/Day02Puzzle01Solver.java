package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solver for Day 2 Puzzle 1 of Advent of Code 2023.
 * This solver processes game data to determine which games are possible
 * given specific constraints on the number of cubes.
 */
public class Day02Puzzle01Solver implements Day02PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day02Puzzle01Solver.class.getName());


    /**
     * Main method to execute the solver.
     * Processes the input file and calculates the total sum of the IDs of possible games.
     */
    public static void main(String[] args) {
        Day02Puzzle01Solver solver = new Day02Puzzle01Solver();
        int sum = solver.solve();
        logger.log(Level.INFO, "Total sum: {}", sum);
    }


    /**
     * Solves the puzzle by processing the input file and summing the IDs of possible games.
     *
     * @return The sum of the IDs of all possible games.
     */
    @Override
    public int solve() {
        return FileReaderUtil.processFile("/day02/day02_input.txt", this::getIdValue);
    }

    /**
     * Determines the ID value of a game based on its possibility.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The ID of the game if it is possible, or 0 otherwise.
     */
    int getIdValue(String line) {
        Game game = createGameFromLine(line);
        if (game.isPossible()) {
            return game.getId();
        }
        return 0;
    }
}
