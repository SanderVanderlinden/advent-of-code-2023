package com.sandervanderlinden.adventofcode2023.day08;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day08.nodes.Node;

import java.util.HashSet;
import java.util.Set;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractWordsAsList;

/**
 * Abstract class for solving Day7 puzzles in the Advent of Code 2023.
 */
public abstract class Day08PuzzleSolver implements BasePuzzleSolver {

    private String instructions;
    private Set<Node> nodes = new HashSet<>();

    @Override
    public void processLine(String line) {
        if (line.contains("=")){
            nodes.add(new Node(line));
        }
        else if (!line.isEmpty()){
            instructions = line;
        }
    }

    @Override
    public Object finalizeSolver() {
        // maak hashmap die AAA naar de AAA node mapt
        // zoek node aaa
        //while niet zzz
        //return counter
        // var firstNode = nodes.stream().findFirst().
        return 0;
    }

}
