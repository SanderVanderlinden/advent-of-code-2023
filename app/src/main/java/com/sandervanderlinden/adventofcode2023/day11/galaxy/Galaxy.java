package com.sandervanderlinden.adventofcode2023.day11.galaxy;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Galaxy galaxy)) return false;
        return getY() == galaxy.getY() && getX() == galaxy.getX();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getY(), getX());
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    public int getY() {
        return y;
    }
}
