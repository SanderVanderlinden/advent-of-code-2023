package com.sandervanderlinden.adventofcode2023.day02;

import com.sandervanderlinden.adventofcode2023.day02.game.Game;
import org.junit.jupiter.api.Test;

import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Puzzle01SolverTest {

    private final Day02Puzzle01Solver solver = new Day02Puzzle01Solver();


    @Test
    void getIdValue_whenPossible_shouldReturnId() {
        int expected = 1;
        assertEquals(expected, solver.getIdValue(linePresentingPossibleGame()));
    }

    @Test
    void getIdValue_whenImpossible_shouldReturnZero() {
        int expected = 0;
        assertEquals(expected, solver.getIdValue(linePresentingImpossibleGame()));
    }

    @Test
    void extractGameId_shouldReturnId() {
        int expected = 31;
        assertEquals(expected, solver.extractGameId(linePresentingImpossibleGame()));
    }

    @Test
    void createGameFromLine_shouldCreateCorrectGame() {
        Game expected = createStandardGame();
        assertEquals(expected, solver.createGameFromLine(linePresentingPossibleGame()));
    }
}