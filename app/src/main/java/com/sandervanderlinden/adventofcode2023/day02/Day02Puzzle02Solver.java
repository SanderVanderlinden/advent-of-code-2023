package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Solver for Day 2 Puzzle 1 of Advent of Code 2023.
 * This solver processes game data to determine which games are possible
 * given specific constraints on the number of cubes.
 */
public class Day02Puzzle02Solver extends Day02PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day02Puzzle02Solver.class.getName());

    /**
     * Main method to execute the solver.
     * Processes the input file and calculates the total sum of the IDs of possible games.
     */
    public static void main(String[] args) {
        Day02Puzzle02Solver solver = new Day02Puzzle02Solver();
        int sum = solver.solve("day02/day02_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }


    /**
     * Determines the power value of a game.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The power value of the game.
     */
    public int processLine(String line) {
        Game game = createGameFromLine(line);

        return Stream.of(Color.values())
                .mapToInt(game::findMaximum)
                .reduce(1, (a, b) -> a * b);
    }


}
