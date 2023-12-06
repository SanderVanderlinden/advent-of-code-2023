package com.sandervanderlinden.adventofcode2023.day04;

import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Puzzle01SolverTest {

    private final Day04Puzzle01Solver solver = new Day04Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 13;
        String filepath = "day04/day04_test_input.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }
}