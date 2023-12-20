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

    int y = 0;
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
            y++;
        }
        y++;
    }

    @Override
    public Object finalizeSolver() {
        checkEmptyColumns();
        return (long)calculateDistances();
    }

    private int calculateDistances() {
        int sum = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i; j < galaxies.size(); j++) {
                sum += calculateDistance(galaxies.get(i), galaxies.get(j));
            }
        }
        return sum;
    }

    private int calculateDistance(Galaxy g1, Galaxy g2) {
        return (g2.getX() - g1.getX() + g2.getY() - g1.getY());
    }

    private void checkEmptyColumns() {
        List<Integer> emptyColumns = createListOfEmptyColumns();
        galaxies.forEach(galaxy -> galaxy.setX(calculateNewX(galaxy.getX(), emptyColumns)));
    }

    private int calculateNewX(int x, List<Integer> emptyColumns) {
        return x + getAmountOfEmptyColumnsBeforeX(x, emptyColumns);
    }

    private int getAmountOfEmptyColumnsBeforeX(int x, List<Integer> emptyColumns) {
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