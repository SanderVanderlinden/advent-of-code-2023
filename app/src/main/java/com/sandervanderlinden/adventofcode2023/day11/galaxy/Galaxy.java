package com.sandervanderlinden.adventofcode2023.day11.galaxy;

public class Galaxy {

    private final int y;
    private int x;

    public Galaxy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
}
