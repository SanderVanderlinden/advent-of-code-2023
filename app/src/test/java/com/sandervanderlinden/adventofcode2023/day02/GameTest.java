package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        String line = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        Game game = solver.createGameFromLine(line);
        boolean expected = false;
        assertEquals(expected, game.isPossible());
    }
}