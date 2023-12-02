package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

public class Day02Puzzle01Solver {
    public static void main(String[] args) {
        Day02Puzzle01Solver solver = new Day02Puzzle01Solver();
        int sum = FileReaderUtil.processFile("/day02/day02_input.txt", solver::getIdValue);
        System.out.println("Total sum: " + sum);
    }

    /**
     * Returns the id of the game, if the game is possible and 0 otherwise.
     *
     * @param line The string line to extract digits from.
     * @return game id or 0.
     */
    public int getIdValue(String line) {
        if (isSolvable(line)){
            return getId(line);
        }
        return 0;
    }

    private int getId(String line) {
        //TODO implement
        return 0;
    }

    private boolean isSolvable(String line) {
        //TODO implement
        return true;
    }
}
