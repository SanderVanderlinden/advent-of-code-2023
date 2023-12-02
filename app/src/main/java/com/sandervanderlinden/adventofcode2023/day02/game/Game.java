package com.sandervanderlinden.adventofcode2023.day02.game;

import java.util.Set;

public record Game(
        int id,
        Set<CubeReveal> cubeReveals,
        int greenCubesMaximumShown,
        int redCubesMaximumShown,
        int blueCubesMaximumShown
) {
    public boolean isPossible() {
        //TODO implement
        return true;
    }
}
