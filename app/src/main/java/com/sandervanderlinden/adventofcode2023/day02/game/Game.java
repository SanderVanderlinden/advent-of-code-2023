package com.sandervanderlinden.adventofcode2023.day02.game;

import java.util.EnumMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Game {
    private final int id;
    private final Set<CubeReveal> cubeReveals;
    private final EnumMap<Color, Integer> revealedMaximums;


    public Game(int id, Set<CubeReveal> cubeReveals) {
        this.id = id;
        this.cubeReveals = cubeReveals;
        this.revealedMaximums = new EnumMap<>(Color.class);
        Stream.of(Color.values())
                .forEach(this::setMaximum);
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return getId() == game.getId() && Objects.equals(cubeReveals, game.cubeReveals);
    }

    private void setMaximum(Color color) {
        revealedMaximums.put(color, findMaximum(color));
    }

    private int findMaximum(Color color) {
        return cubeReveals.stream()
                .filter(c -> c.color() == color)
                .mapToInt(CubeReveal::amount)
                .max()
                .orElse(0);
    }

    public boolean isPossible() {
        //TODO implement
        return true;
    }
}
