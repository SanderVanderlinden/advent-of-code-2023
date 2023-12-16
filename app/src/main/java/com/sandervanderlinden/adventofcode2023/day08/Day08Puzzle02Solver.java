package com.sandervanderlinden.adventofcode2023.day08;

import com.sandervanderlinden.adventofcode2023.day08.nodes.Node;

import java.util.HashSet;
import java.util.Iterator;
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
    Set<Long> amountOfStepsPerNode = new HashSet<>();

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day08Puzzle02Solver solver = new Day08Puzzle02Solver();
        String filePath = "day08/day08_input.txt";
        calculateAndLogResult(solver, logger, filePath, Long.class);
    }

    @Override
    public Object finalizeSolver() {
        Set<Node> startingNodes = getStartingNodes(nodes);

        for (Node startingNode : startingNodes) {
            amountOfStepsPerNode.add(amountOfStepsToReachEndNode(startingNode));
        }

        return leastCommonMultiple(amountOfStepsPerNode);
    }

    private long leastCommonMultiple(Set<Long> amountOfStepsPerNode) {
        Iterator<Long> iterator = amountOfStepsPerNode.iterator();
        long leastCommonMultiple = iterator.next();

        while (iterator.hasNext()) {
            long nextNumber = iterator.next();
            leastCommonMultiple = (leastCommonMultiple * nextNumber) / greatestCommonDivisor(leastCommonMultiple, nextNumber);
        }

        return leastCommonMultiple;
    }


    private long greatestCommonDivisor(long a, long b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }

    Set<Node> getStartingNodes(Map<String, Node> nodes) {
        return nodes
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().endsWith("A"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
    }

    private long amountOfStepsToReachEndNode(Node startingNode) {
        int counter = 0;
        Node currentNode = startingNode;
        int instructionsLength = instructions.length();

        while (!isFinalPosition(currentNode)) {
            char instruction = instructions.charAt(counter % instructionsLength);
            currentNode = instruction == 'L' ? nodes.get(currentNode.left()) : nodes.get(currentNode.right());
            counter++;
        }

        return counter;
    }

    private boolean isFinalPosition(Node node) {
        return node.location().endsWith("Z");
    }
}