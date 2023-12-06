package com.sandervanderlinden.adventofcode2023.day05;

import com.sandervanderlinden.adventofcode2023.utils.FileReaderUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Puzzle02SolverTest {

    private final Day05Puzzle02Solver solver = new Day05Puzzle02Solver();


    @Test
    void testSolve() {
        int expected = 0;
        String filepath = "day04/day04_test_input.txt";
        assertEquals(expected, FileReaderUtil.processFile(filepath, solver::processLine));
    }
}