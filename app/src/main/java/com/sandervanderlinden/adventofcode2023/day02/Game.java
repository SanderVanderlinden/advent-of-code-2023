package com.sandervanderlinden.adventofcode2023.day02;

import java.util.Map;
import java.util.Set;

public record Game(
        int id,
        Set<Map<String, Integer>> cubeReveals,
        int greenCubesMaximumShown,
        int redCubesMaximumShown,
        int blueCubesMaximumShown
) {
}
