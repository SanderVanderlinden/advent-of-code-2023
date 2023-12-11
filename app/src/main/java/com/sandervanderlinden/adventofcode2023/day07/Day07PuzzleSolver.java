package com.sandervanderlinden.adventofcode2023.day07;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day07.cards.Hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Abstract class for solving Day7 puzzles in the Advent of Code 2023.
 */
public abstract class Day07PuzzleSolver implements BasePuzzleSolver {

    List<Hand> hands = new ArrayList<>();

    @Override
    public Object finalizeSolver() {
        hands.sort(Comparator.naturalOrder());
        return IntStream.range(0, hands.size())
                .map(i -> (i + 1) * hands.get(i).getBid())
                .sum();
    }

}
