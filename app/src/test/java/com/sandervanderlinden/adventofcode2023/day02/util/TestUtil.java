package com.sandervanderlinden.adventofcode2023.day02.util;

import com.sandervanderlinden.adventofcode2023.day02.game.Color;
import com.sandervanderlinden.adventofcode2023.day02.game.CubeReveal;
import com.sandervanderlinden.adventofcode2023.day02.game.Game;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class TestUtil {

    private static final EnumMap<Color, Integer> cubesInBag;

    static {
        cubesInBag = new EnumMap<>(Color.class);
        cubesInBag.put(Color.RED, 12);   // Example values
        cubesInBag.put(Color.GREEN, 13);
        cubesInBag.put(Color.BLUE, 14);
    }

    public static String linePresentingPossibleGame() {
        return "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
    }

    public static String linePresentingImpossibleGame() {
        return "Game 31: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
    }


    public static Game createStandardGame() {
        Set<CubeReveal> cubeReveals = new HashSet<>();
        cubeReveals.add(new CubeReveal(Color.BLUE, 3));
        cubeReveals.add(new CubeReveal(Color.RED, 4));
        cubeReveals.add(new CubeReveal(Color.RED, 1));
        cubeReveals.add(new CubeReveal(Color.GREEN, 2));
        cubeReveals.add(new CubeReveal(Color.BLUE, 6));
        cubeReveals.add(new CubeReveal(Color.GREEN, 2));
        return new Game(1, cubeReveals, cubesInBag);
    }
}
