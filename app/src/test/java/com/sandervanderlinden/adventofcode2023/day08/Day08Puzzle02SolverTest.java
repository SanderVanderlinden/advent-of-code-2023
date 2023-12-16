package com.sandervanderlinden.adventofcode2023.day08;

import com.sandervanderlinden.adventofcode2023.day08.nodes.Node;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day08Puzzle02SolverTest {

    private final Day08Puzzle02Solver solver = new Day08Puzzle02Solver();

    @Test
    void testSolve() {
        int expected = 6;
        String filepath = "day08/day08_test_input_03.txt";
        Object result = solver.solve(filepath);

        assertTrue(result instanceof Integer, "Result should be a int, but was: " + result.getClass());
        long actual = (Integer) result;

        assertEquals(expected, actual);
    }

    @Test
    void testGetStartingNodes() {
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("11A", new Node("11A", "11B", "XXX"));
        nodes.put("11B", new Node("11B", "XXX", "11Z"));
        nodes.put("22A", new Node("22A", "22B", "XXX"));
        nodes.put("22Z", new Node("22Z", "22B", "22B"));

        Set<Node> nodesExpected = new HashSet<>();
        nodesExpected.add(new Node("11A", "11B", "XXX"));
        nodesExpected.add(new Node("22A", "22B", "XXX"));

        Set<Node> nodesActual = solver.getStartingNodes(nodes);
        assertEquals(nodesExpected, nodesActual);
    }
}