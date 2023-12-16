package com.sandervanderlinden.adventofcode2023.day08;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day08.nodes.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractWordsAsList;

/**
 * Abstract class for solving Day7 puzzles in the Advent of Code 2023.
 */
public abstract class Day08PuzzleSolver implements BasePuzzleSolver {

    private final Map<String, Node> nodes = new HashMap<>();
    private String instructions;

    @Override
    public void processLine(String line) {
        if (line.contains("=")) {
            List<String> lineElements = extractWordsAsList(line);
            nodes.put(lineElements.get(0), new Node(lineElements.get(0), lineElements.get(1), lineElements.get(2)));
        }
        else if (!line.isEmpty()) {
            instructions = line;
        }
    }

    @Override
    public Object finalizeSolver() {
        int counter = 0;
        Node currentNode = nodes.get("AAA");
        Node endNode = nodes.get("ZZZ");
        while (!currentNode.equals(endNode)) {
            if (instructions.charAt(counter % instructions.length()) == 'L') {
                currentNode = nodes.get(currentNode.left());
            }
            else {
                currentNode = nodes.get(currentNode.right());
            }
            counter += 1;
        }
        //while niet zzz
        //return counter
        // var firstNode = nodes.stream().findFirst().
        return counter;
    }
}
