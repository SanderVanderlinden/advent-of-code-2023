package com.sandervanderlinden.adventofcode2023.day08.nodes;

import java.util.List;

import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.extractWordsAsList;

public record Node(String location, String left, String right) {
    public Node(String line) {
        this(parseLineElement(line, 0),
                parseLineElement(line, 1),
                parseLineElement(line, 2));
    }

    private static String parseLineElement(String line, int index) {
        List<String> lineElements = extractWordsAsList(line);
        if (lineElements.size() <= index) {
            throw new IllegalArgumentException("Line does not contain enough elements to create a Node");
        }
        return lineElements.get(index);
    }
}
