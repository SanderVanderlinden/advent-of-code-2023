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

    final Map<String, Node> nodes = new HashMap<>();
    String instructions;

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
}
