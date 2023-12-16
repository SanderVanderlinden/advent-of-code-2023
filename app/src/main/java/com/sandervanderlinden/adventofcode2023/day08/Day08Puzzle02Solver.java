package com.sandervanderlinden.adventofcode2023.day08;

import com.sandervanderlinden.adventofcode2023.day08.nodes.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;

/**
 * This class solves the second puzzle of Day 8 in the Advent of Code 2023.
 */
public class Day08Puzzle02Solver extends Day08PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day08Puzzle02Solver.class.getName());

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day08Puzzle02Solver solver = new Day08Puzzle02Solver();
        String filePath = "day08/day08_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }

    @Override
    public Object finalizeSolver() {
        int counter = 0;
        int instructionsLength = instructions.length();
        Set<Node> currentNodes = getStartingNodes(nodes);

        while (!isFinalPosition(currentNodes)) {
            char instruction = instructions.charAt(counter % instructionsLength);

            Set<Node> nextNodes = new HashSet<>();
            for (Node node : currentNodes) {
                nextNodes.add(instruction == 'L' ? nodes.get(node.left()) : nodes.get(node.right()));
            }

            currentNodes = nextNodes;
            counter++;
        }

        return counter;
    }

    Set<Node> getStartingNodes(Map<String, Node> nodes) {
        return nodes
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().endsWith("A"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    private boolean isFinalPosition(Set<Node> currentNodes) {
        return currentNodes.stream().allMatch(node -> node.location().endsWith("Z"));
    }
}