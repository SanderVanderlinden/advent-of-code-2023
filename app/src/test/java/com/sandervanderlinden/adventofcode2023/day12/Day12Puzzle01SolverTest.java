package com.sandervanderlinden.adventofcode2023.day12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day12Puzzle01SolverTest {

    private final Day12Puzzle01Solver solver = new Day12Puzzle01Solver();

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(1, "???.### 1,1,3"),
                Arguments.of(4, ".??..??...?##. 1,1,3"),
                Arguments.of(1, "?#?#?#?#?#?#?#? 1,3,1,6"),
                Arguments.of(1, "????.#...#... 4,1,1"),
                Arguments.of(4, "????.######..#####. 1,6,5"),
                Arguments.of(10, "?###???????? 3,2,1")
        );
    }

    @Test
    void testSolve() {
        long expected = 21;
        String filepath = "day12/day12_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testExtractValueFromLine(int expected, String line) {
        Object result = solver.extractValueFromLine(line);
        assertEquals(expected, result);
    }

}