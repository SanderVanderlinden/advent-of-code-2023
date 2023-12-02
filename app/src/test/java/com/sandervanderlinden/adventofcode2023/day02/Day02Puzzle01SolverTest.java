package com.sandervanderlinden.adventofcode2023.day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Puzzle01SolverTest {

    private final Day02Puzzle01Solver solver = new Day02Puzzle01Solver();


    @Test
    void getIdValue_whenPossible_shouldReturnId() {
        String line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        int expected = 1;
        assertEquals(expected, solver.getIdValue(line));
    }

    @Test
    void getIdValue_whenImpossible_shouldReturnZero() {
        String line = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        int expected = 0;
        assertEquals(expected, solver.getIdValue(line));
    }


}