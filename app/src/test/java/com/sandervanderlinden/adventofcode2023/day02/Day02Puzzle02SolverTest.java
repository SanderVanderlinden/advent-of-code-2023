package com.sandervanderlinden.adventofcode2023.day02;

import org.junit.jupiter.api.Test;

import static com.sandervanderlinden.adventofcode2023.day02.util.TestUtil.linePresentingPossibleGame;
import static org.junit.jupiter.api.Assertions.*;

class Day02Puzzle02SolverTest {

    private final Day02Puzzle02Solver solver = new Day02Puzzle02Solver();


    @Test
    void getPower_whenPossible_shouldReturnPower() {
        int expected = 48;
        assertEquals(expected, solver.getPower(linePresentingPossibleGame()));
    }
}