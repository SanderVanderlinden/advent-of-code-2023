package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Game game = createGameFromLine(line);
        if (game.isPossible()) {
            return game.id();
        }
        return 0;
    }

    public Game createGameFromLine(String line) {
        //TODO implement
        return new Game(extractGameId(line), new HashSet<>(), 0, 0, 0);
    }

    public int extractGameId(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NoDigitFoundException("No Id found in the line: " + line);
    }

}
