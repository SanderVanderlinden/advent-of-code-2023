package com.sandervanderlinden.adventofcode2023.day02.game;

import com.sandervanderlinden.adventofcode2023.day02.Day02Puzzle01Solver;
import org.junit.jupiter.api.Test;

import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.createStandardGame;
import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.linePresentingImpossibleGame;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}