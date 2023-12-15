package com.sandervanderlinden.adventofcode2023.day02.game;

import com.sandervanderlinden.adventofcode2023.day02.Day02Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.createStandardGame;
import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.linePresentingImpossibleGame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameTest {

    private final Day02Puzzle01Solver solver = new Day02Puzzle01Solver();

    @Test
    void isPossible_whenPossible_shouldReturnTrue() {
        String line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game game = solver.createGameFromLine(line);
        boolean expected = true;
        assertEquals(expected, game.isPossible());
    }

    @Test
    void isPossible_whenImpossible_shouldReturnFalse() {
        Game game = solver.createGameFromLine(linePresentingImpossibleGame());
        boolean expected = false;
        assertEquals(expected, game.isPossible());
    }

    @Test
    void findMaximum_shouldReturnCorrectMaximums() {
        Game game = createStandardGame();
        int expectedRedCubes = 4;
        assertEquals(expectedRedCubes, game.findMaximum(Color.RED));
        int expectedGreenCubes = 2;
        assertEquals(expectedGreenCubes, game.findMaximum(Color.GREEN));
        int expectedBlueCubes = 6;
        assertEquals(expectedBlueCubes, game.findMaximum(Color.BLUE));
    }

    @Test
    void testEquals() {
        Game game = solver.createGameFromLine("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameDifferentId = solver.createGameFromLine("Game 8: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameEqual = solver.createGameFromLine("Game 1: 3 blue, 1 red; 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameEqualMaximumDifferentCubeReveals = solver.createGameFromLine("Game 1: 3 blue, 3 red; 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameDifferent = solver.createGameFromLine("Game 1: 3 blue, 8 red; 4 red; 1 red, 2 green, 6 blue; 2 green");

        assertEquals(game, game);
        assertEquals(game, gameEqual);
        assertNotEquals(game, gameDifferentId);
        assertNotEquals(game, gameEqualMaximumDifferentCubeReveals);
        assertNotEquals(game, gameDifferent);
        assertNotEquals(null, game);
        assertNotEquals(game, new Object());
    }

    @Test
    void testHashCode() {
        Game game = solver.createGameFromLine("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameEqual = solver.createGameFromLine("Game 1: 3 blue, 1 red; 4 red; 1 red, 2 green, 6 blue; 2 green");
        Game gameDifferent = solver.createGameFromLine("Game 1: 3 blue, 8 red; 4 red; 1 red, 2 green, 6 blue; 2 green");

        assertEquals(game.hashCode(), gameEqual.hashCode());
        assertNotEquals(game.hashCode(), gameDifferent.hashCode());
    }
}