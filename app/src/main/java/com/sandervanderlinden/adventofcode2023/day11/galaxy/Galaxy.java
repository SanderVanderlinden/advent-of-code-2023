package com.sandervanderlinden.adventofcode2023.day11.galaxy;

import java.util.Objects;

public class Galaxy {

    private final long y;
    private long x;

    public Galaxy(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
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

    public long getY() {
        return y;
    }
}
