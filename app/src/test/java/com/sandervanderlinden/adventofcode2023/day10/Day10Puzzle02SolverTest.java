package com.sandervanderlinden.adventofcode2023.day10;

import com.sandervanderlinden.adventofcode2023.day10.pipe.Pipe;
import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sandervanderlinden.adventofcode2023.util.FileReaderUtil.countCharsInFirstNonEmptyLine;
import static com.sandervanderlinden.adventofcode2023.util.FileReaderUtil.countLines;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day10Puzzle02SolverTest {

    private final Day10Puzzle02Solver solver = new Day10Puzzle02Solver();

    private static Stream<ParameterizedTestCase> provideTestCases() {
        return Stream.of(
                new ParameterizedTestCase(4, "day10/day10_test_input_02.txt"),
                new ParameterizedTestCase(8, "day10/day10_test_input_03.txt"),
                new ParameterizedTestCase(10, "day10/day10_test_input_04.txt")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolve(ParameterizedTestCase testCase) {
        Object result = solver.solve(testCase.filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(testCase.expected, actual);
    }

    @Test
    void getAmountOfHorizontalPipes() {
        String filePath = "day10/day10_test_input_04.txt";
        solver.pipeGrid = new Pipe[countCharsInFirstNonEmptyLine(filePath)][countLines(filePath)];
        FileReaderUtil.processFile(filePath, solver::processLine);
        solver.findFirstPipeAfterStart();
        solver.createLoop();
        solver.removeNonLoopElements();

        int amountOfPipes = solver.getAmountOfHorizontalPipes(10, 10);
        int expected = 4;
        assertEquals(expected, amountOfPipes);
    }

    private static class ParameterizedTestCase {

        final int expected;
        final String filepath;

        ParameterizedTestCase(int expected, String filepath) {
            this.expected = expected;
            this.filepath = filepath;
        }
    }
}