package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.CubeReveal;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Day02PuzzleSolver {

    /**
     * Provides a map of the maximum number of cubes of each color available in the bag.
     * This map is used to determine if a game configuration is possible.
     *
     * @return A Map with keys as Color and values as Integer representing the maximum number of cubes of each color.
     */
    default Map<Color, Integer> getCubesInBag() {
        EnumMap<Color, Integer> map = new EnumMap<>(Color.class);
        map.put(Color.RED, 12);
        map.put(Color.GREEN, 13);
        map.put(Color.BLUE, 14);
        return map;
    }

    /**
     * Solves the puzzle by processing the input file and summing some puzzle specific value.
     *
     * @return The sum of these values.
     */
    int solve();

    /**
     * Creates a Game object from a line of the input file.
     *
     * @param line A string representing a line from the puzzle input.
     * @return A Game object representing the game described in the line.
     */
    default Game createGameFromLine(String line) {
        return new Game(extractGameId(line), extractCubeReveals(line), getCubesInBag());
    }

    /**
     * Extracts cube reveals from a line of the input file.
     *
     * @param line A string representing a line from the puzzle input.
     * @return A set of CubeReveal objects extracted from the line.
     */
    default Set<CubeReveal> extractCubeReveals(String line) {
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

    /**
     * Extracts the game ID from a line of the input file.
     *
     * @param line A string representing a line from the puzzle input.
     * @return The game ID extracted from the line.
     */
    default int extractGameId(String line) {
        String gameId = line.substring(5, line.indexOf(":"));
        return Integer.parseInt(gameId);
    }
}
