package com.sandervanderlinden.adventofcode2023.day02;

/**
 * Solver for Day 2 Puzzle 1 of Advent of Code 2023.
 * This solver processes game data to determine which games are possible
 * given specific constraints on the number of cubes.
 */
public class Day02Puzzle01Solver implements Day02PuzzleSolver {

    /**
     * Main method to execute the solver.
     * Processes the input file and calculates the total sum of the IDs of possible games.
     */
    public static void main(String[] args) {
        Day02Puzzle01Solver solver = new Day02Puzzle01Solver();
        int sum = solver.solve();
        System.out.println("Total sum: " + sum);
    }


}
