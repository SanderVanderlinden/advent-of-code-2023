package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.stream.Stream;

/**
 * Solver for Day 2 Puzzle 1 of Advent of Code 2023.
 * This solver processes game data to determine which games are possible
 * given specific constraints on the number of cubes.
 */
public class Day02Puzzle02Solver implements Day02PuzzleSolver {

    /**
     * Main method to execute the solver.
     * Processes the input file and calculates the total sum of the IDs of possible games.
     */
    public static void main(String[] args) {
        Day02Puzzle02Solver solver = new Day02Puzzle02Solver();
        int sum = solver.solve();
        System.out.println("Total sum: " + sum);
    }

    /**
     * Solves the puzzle by processing the input file and summing the IDs of possible games.
     *
     * @return The sum of the IDs of all possible games.
     */
    public int solve() {
        return FileReaderUtil.processFile("/day02/day02_input.txt", this::getPower);
    }

    /**
     * Determines the power value of a game.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The power value of the game.
     */
    int getPower(String line) {
        Game game = createGameFromLine(line);

        return Stream.of(Color.values())
                .mapToInt(game::findMaximum)
                .reduce(1, (a, b) -> a * b);
    }


}
