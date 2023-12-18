package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;

import java.util.logging.Logger;
import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

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
        Day02PuzzleSolver solver = new Day02Puzzle02Solver();
        String filePath = "day02/day02_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }


    /**
     * Determines the power value of a game.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The power value of the game.
     */
    public long extractValueFromLine(String line) {
        Game game = createGameFromLine(line);

        return Stream.of(Color.values())
                .mapToInt(game::findMaximum)
                .reduce(1, (a, b) -> a * b);
    }


}
