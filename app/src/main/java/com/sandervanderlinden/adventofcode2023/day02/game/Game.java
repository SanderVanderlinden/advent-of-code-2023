package com.sandervanderlinden.adventofcode2023.day02.game;

import java.util.EnumMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Game {
    private final int id;
    private final Set<CubeReveal> cubeReveals;
    private final EnumMap<Color, Integer> MostRevealedCubes;
    private final EnumMap<Color, Integer> cubesInBag;


    public Game(int id, Set<CubeReveal> cubeReveals, EnumMap<Color, Integer> cubesInBag) {
        this.id = id;
        this.cubeReveals = cubeReveals;
        this.cubesInBag = cubesInBag;
        this.MostRevealedCubes = new EnumMap<>(Color.class);
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
        MostRevealedCubes.put(color, findMaximum(color));
    }

    public int findMaximum(Color color) {
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
