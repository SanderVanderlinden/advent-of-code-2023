package com.sandervanderlinden.adventofcode2023.day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractNumbersAsList;
import static org.junit.jupiter.api.Assertions.*;

class Day09Puzzle01SolverTest {

    private final Day09Puzzle01Solver solver = new Day09Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 114;
        String filepath = "day09/day09_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }

    @Test
    void testExtractValueFromLine() {
        String line = "3 10 23 46 99 234 563 1310 2904 6131 12351 23745 43470 75464 123501 189097 268370 349700 418439 484617 669380";
        int expected = 1424472;
        assertEquals(expected, solver.extractValueFromLine(line));
    }

    @Test
    void testCalculateNextSequence() {
        List<Long> line = extractNumbersAsList("3 10 23 46 99 234 563 1310 2904 6131 12351 23745 43470 75464 123501 189097 268370 349700 418439 484617 669380");
        List<Long> expected = extractNumbersAsList("7 13 23 53 135 329 747 1594 3227 6220 11394 19725 31994 48037 65596 79273 81330 68739 66178 184763");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("6 10 30 82 194 418 847 1633 2993 5174 8331 12269 16043 17559 13677 2057 -12591 -2561 118585");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[4, 20, 52, 112, 224, 429, 786, 1360, 2181, 3157, 3938, 3774, 1516, -3882, -11620, -14648, 10030, 121146]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[16, 32, 60, 112, 205, 357, 574, 821, 976, 781, -164, -2258, -5398, -7738, -3028, 24678, 111116]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[16, 28, 52, 93, 152, 217, 247, 155, -195, -945, -2094, -3140, -2340, 4710, 27706, 86438]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[12, 24, 41, 59, 65, 30, -92, -350, -750, -1149, -1046, 800, 7050, 22996, 58732]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[12, 17, 18, 6, -35, -122, -258, -400, -399, 103, 1846, 6250, 15946, 35736]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[5, 1, -12, -41, -87, -136, -142, 1, 502, 1743, 4404, 9696, 19790]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[-4, -13, -29, -46, -49, -6, 143, 501, 1241, 2661, 5292, 10094]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[-9, -16, -17, -3, 43, 149, 358, 740, 1420, 2631, 4802]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[-7, -1, 14, 46, 106, 209, 382, 680, 1211, 2171]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[6, 15, 32, 60, 103, 173, 298, 531, 960]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[9, 17, 28, 43, 70, 125, 233, 429]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[8, 11, 15, 27, 55, 108, 196]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[3, 4, 12, 28, 53, 88]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[1, 8, 16, 25, 35]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[7, 8, 9, 10]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[1, 1, 1]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[0, 0]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("[0]");
        assertEquals(expected, solver.calculateNextSequence(line));
    }

    @Test
    void testCalculateNextSequenceWithNegativeNumbers() {
        List<Long> line = extractNumbersAsList("10 5 -5 -20 -40 -65 -95 -130 -170 -215 -265 -320 -380 -445 -515 -590 -670 -755 -845 -940 -1040");
        List<Long> expected = extractNumbersAsList("[-5, -10, -15, -20, -25, -30, -35, -40, -45, -50, -55, -60, -65, -70, -75, -80, -85, -90, -95, -100]");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("-5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5, -5");
        assertEquals(expected, solver.calculateNextSequence(line));

        line = expected;
        expected = extractNumbersAsList("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        assertEquals(expected, solver.calculateNextSequence(line));
    }

    @Test
    void testAllZeros() {
        List<Long> line = extractNumbersAsList("10 5 -5 -20 -40 -65 -95 -130 -170 -215 -265 -320 -380 -445 -515 -590 -670 -755 -845 -940 -1040");
        assertFalse(solver.allZeros(line));

        line = extractNumbersAsList("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        assertTrue(solver.allZeros(line));
    }
}