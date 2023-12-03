package com.sandervanderlinden.adventofcode2023.day02.game;

public enum Color {
    RED, GREEN, BLUE;

    public static Color fromString(String colorStr) {
        return switch (colorStr.toLowerCase()) {
            case "red" -> RED;
            case "green" -> GREEN;
            case "blue" -> BLUE;
            default -> throw new IllegalArgumentException("Unknown color: " + colorStr);
        };
    }
}
