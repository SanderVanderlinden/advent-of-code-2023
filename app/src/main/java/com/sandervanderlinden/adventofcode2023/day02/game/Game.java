package com.sandervanderlinden.adventofcode2023.day02.game;

import java.util.Set;

public class Game {
    private final int id;
    private final Set<CubeReveal> cubeReveals;
    private int greenCubesMaximumShown;
    private int redCubesMaximumShown;
    private int blueCubesMaximumShown;

    public Game(int id, Set<CubeReveal> cubeReveals) {
        this.id = id;
        this.cubeReveals = cubeReveals;
        calculateMaximums();
    }

    private void calculateMaximums() {
        //TODO implement
    }

    public boolean isPossible() {
        //TODO implement
        return true;
    }

    public int getId() {
        return id;
    }
}
