package com.sandervanderlinden.adventofcode2023.day07;


import com.sandervanderlinden.adventofcode2023.day07.cards.Hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static com.sandervanderlinden.adventofcode2023.util.CalculationUtil.calculateAndLogResult;
import static com.sandervanderlinden.adventofcode2023.util.LineProcessingUtility.spaceSeparatedStringToList;

/**
 * This class solves the first puzzle of Day 6 in the Advent of Code 2023.
 */
public class Day07Puzzle01Solver extends Day07PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day07Puzzle01Solver.class.getName());
    List<Hand> hands = new ArrayList<>();

    /**
     * The main method that initializes the solver, processes the input file,
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day07Puzzle01Solver solver = new Day07Puzzle01Solver();
        String filePath = "day07/day07_input.txt";
        calculateAndLogResult(solver, logger, filePath, Integer.class);
    }

    @Override
    public void processLine(String line) {
        var lineContents = spaceSeparatedStringToList(line);
        hands.add(new Hand(lineContents.get(0), Integer.parseInt(lineContents.get(1))));
    }

    @Override
    public Object finalizeSolver() {
        hands.sort(Comparator.naturalOrder());
        return IntStream.range(0, hands.size())
                .map(i -> (i + 1) * hands.get(i).getBid())
                .sum();    }
}