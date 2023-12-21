package com.sandervanderlinden.adventofcode2023.day11;

import com.sandervanderlinden.adventofcode2023.day11.galaxy.Galaxy;
import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sandervanderlinden.adventofcode2023.day11.TestUtil.ListRepresentingTestImage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day11Puzzle01SolverTest {

    private final Day11Puzzle01Solver solver = new Day11Puzzle01Solver();

    @Test
    void testSolve() {
        int expected = 374;
        String filepath = "day11/day11_test_input.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Long, "Result should be a long, but was: " + result.getClass());
        long actual = (long) result;

        assertEquals(expected, actual);
    }

    @Test
    void testGrid() {
        String filePath = "day11/day11_test_input.txt";
        FileReaderUtil.processFile(filePath, solver::processLine);
        solver.checkEmptyColumns();

        List<Galaxy> actual = solver.galaxies;
        List<Galaxy> expected = ListRepresentingTestImage();
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateDistance() {
        Galaxy galaxy1 = new Galaxy(4, 1);
        Galaxy galaxy2 = new Galaxy(12, 4);

        int expected = solver.calculateDistance(galaxy1, galaxy2);
        int actual = 11;
        assertEquals(expected, actual);

        expected = solver.calculateDistance(galaxy2, galaxy1);
        assertEquals(expected, actual);
    }
}