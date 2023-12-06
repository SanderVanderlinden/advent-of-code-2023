package com.sandervanderlinden.adventofcode2023.day04;

import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Puzzle02SolverTest {

    private final Day04Puzzle02Solver solver = new Day04Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 30;
        String filepath = "day04/day04_test_input.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }
}