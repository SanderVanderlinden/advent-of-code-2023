package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Puzzle01SolverTest {

    private final Day05Puzzle01Solver solver = new Day05Puzzle01Solver();


    @Test
    void testSolve() {
        int expected = 45;
        String filepath = "day04/day04_test_input.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }
}