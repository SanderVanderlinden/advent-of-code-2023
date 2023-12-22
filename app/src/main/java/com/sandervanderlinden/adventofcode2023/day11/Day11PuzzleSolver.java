package com.sandervanderlinden.adventofcode2023.day11;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day11.galaxy.Galaxy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Abstract class for solving Day 11 puzzles in the Advent of Code 2023.
 */
public abstract class Day11PuzzleSolver implements BasePuzzleSolver {

    long y = 0;
    long expansionFactor;
    List<Galaxy> galaxies = new ArrayList<>();
    Set<Integer> columnsContainingGalaxies = new HashSet<>();

    @Override
    public void processLine(String line) {
        if (line.contains("#")) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '#') {
                    galaxies.add(new Galaxy(i, y));
                    columnsContainingGalaxies.add(i);
                }
            }
        }
        else {
            y += getExpansionFactor();
        }
        y++;
    }

    long getExpansionFactor() {
        return expansionFactor;
    }
    void setExpansionFactor(long expansionFactor) {
        this.expansionFactor = expansionFactor;
    }

    @Override
    public Object finalizeSolver() {
        checkEmptyColumns();
        return calculateDistances();
    }

    private long calculateDistances() {
        long sum = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                sum += calculateDistance(galaxies.get(i), galaxies.get(j));
            }
        }
        return sum;
    }

    long calculateDistance(Galaxy g1, Galaxy g2) {
        return (Math.abs(g2.getX() - g1.getX()) + Math.abs(g2.getY() - g1.getY()));
    }

    void checkEmptyColumns() {
        List<Integer> emptyColumns = createListOfEmptyColumns();
        galaxies.forEach(galaxy -> galaxy.setX(calculateNewX(galaxy.getX(), emptyColumns)));
    }

    private long calculateNewX(long x, List<Integer> emptyColumns) {
        return x + getExpansionFactor() * getAmountOfEmptyColumnsBeforeX(x, emptyColumns);
    }

    private int getAmountOfEmptyColumnsBeforeX(long x, List<Integer> emptyColumns) {
        return (int) emptyColumns.stream()
                .filter(column -> column < x)
                .count();
    }

    private List<Integer> createListOfEmptyColumns() {
        List<Integer> emptyColumns = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            if (!columnsContainingGalaxies.contains(i)) {
                emptyColumns.add(i);
            }
        }
        return emptyColumns;
    }
}