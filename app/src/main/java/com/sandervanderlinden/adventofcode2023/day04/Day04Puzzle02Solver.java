package com.sandervanderlinden.adventofcode2023.day04;


import com.sandervanderlinden.adventofcode2023.utils.IntegerHolder;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class solves the second puzzle of Day 4 in the Advent of Code 2023.
 * It extends the abstract Day04PuzzleSolver class, providing specific logic to process lines of input
 * and calculate a final output based on the puzzle's rules.
 */
public class Day04Puzzle02Solver extends Day04PuzzleSolver {

    private static final Logger logger = Logger.getLogger(Day04Puzzle02Solver.class.getName());
    private final LinkedList<IntegerHolder> amountOfBonusCards = new LinkedList<>();

    /**
     * The main method that initializes the solver, processes the input file,
     * and logs the total sum calculated by the solver.
     *
     * @param args The command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Day04Puzzle02Solver solver = new Day04Puzzle02Solver();
        int sum = solver.solve("day04/day04_input.txt");
        String message = String.format("Total sum: %d", sum);
        logger.log(Level.INFO, message);
    }

    /**
     * Processes a single line of the input file and calculates a value based on the puzzle logic.
     * This method splits the line into winning numbers and own numbers, then checks for overlaps
     * to calculate the final output value.
     *
     * @param line A single line from the input file.
     * @return The calculated value based on the line's data.
     */
    @Override
    public int processLine(String line) {
        ensureBonusCardsListInitialized();

        int amountOfCards = 1 + amountOfBonusCards.poll().getValue();
        int amountOfMatchingNumbers = getAmountOfMatchingNumbers(line);

        updateBonusCards(amountOfMatchingNumbers, amountOfCards);

        return amountOfCards;
    }


    private void ensureBonusCardsListInitialized() {
        if (amountOfBonusCards.isEmpty()) {
            amountOfBonusCards.add(new IntegerHolder(0));
        }
    }

    private void updateBonusCards(int amountOfMatchingNumbers, int amountOfCards) {
        // Ensure the list has enough elements
        while (amountOfBonusCards.size() < amountOfMatchingNumbers) {
            amountOfBonusCards.add(new IntegerHolder(0)); // Assuming IntegerHolder has a constructor
        }

        for (int i = 0; i < amountOfMatchingNumbers; i++) {
            amountOfBonusCards.get(i).increaseValue(amountOfCards);
        }
    }

}