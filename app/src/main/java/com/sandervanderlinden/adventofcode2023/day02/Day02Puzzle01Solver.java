package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.CubeReveal;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;

import java.util.HashSet;
import java.util.Set;

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
            return game.getId();
        }
        return 0;
    }

    public Game createGameFromLine(String line) {
        return new Game(extractGameId(line), extractCubeReveals(line));
    }

    private Set<CubeReveal> extractCubeReveals(String line) {
        String cubeRevealsString = line.substring(line.indexOf(":") + 1).trim();

        String[] separators = cubeRevealsString.split("[,;]");

        Set<CubeReveal> cubeReveals = new HashSet<>();

        for (String separator : separators) {
            String[] cubeRevealData = separator.trim().split(" ");
            Color color = Color.fromString(cubeRevealData[1]);
            int amount = Integer.parseInt(cubeRevealData[0]);
            cubeReveals.add(new CubeReveal(color, amount));
        }
        return cubeReveals;
    }

    public int extractGameId(String line) {
        String gameId = line.substring(5, line.indexOf(":"));
        return Integer.parseInt(gameId);
    }


}
