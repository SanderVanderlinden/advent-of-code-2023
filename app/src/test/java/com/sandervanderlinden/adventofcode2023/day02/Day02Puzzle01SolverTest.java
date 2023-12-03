package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.CubeReveal;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Puzzle01SolverTest {

    private final Day02Puzzle01Solver solver = new Day02Puzzle01Solver();
    private final String linePresentingPossibleGame = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
    private final String linePresentingImpossibleGame = "Game 31: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";


    @Test
    void getIdValue_whenPossible_shouldReturnId() {
        int expected = 1;
        assertEquals(expected, solver.getIdValue(linePresentingPossibleGame));
    }

    @Test
    void getIdValue_whenImpossible_shouldReturnZero() {
        int expected = 0;
        assertEquals(expected, solver.getIdValue(linePresentingImpossibleGame));
    }

    @Test
    void extractGameId_shouldReturnId() {
        int expected = 31;
        assertEquals(expected, solver.extractGameId(linePresentingImpossibleGame));
    }

    @Test
    void createGameFromLine_shouldCreateCorrectGame() {
        Set<CubeReveal> cubeReveals = new HashSet<>();
        cubeReveals.add(new CubeReveal(Color.BLUE, 3));
        cubeReveals.add(new CubeReveal(Color.RED, 4));
        cubeReveals.add(new CubeReveal(Color.RED, 1));
        cubeReveals.add(new CubeReveal(Color.GREEN, 2));
        cubeReveals.add(new CubeReveal(Color.BLUE, 6));
        cubeReveals.add(new CubeReveal(Color.GREEN, 2));
        Game expected = new Game(1, cubeReveals);
        assertEquals(expected, solver.createGameFromLine(linePresentingPossibleGame));
    }
}