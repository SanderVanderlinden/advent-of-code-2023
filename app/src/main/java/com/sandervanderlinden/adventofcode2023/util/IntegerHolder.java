package com.sandervanderlinden.adventofcode2023.util;

public class IntegerHolder {
    private int value;

    public IntegerHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increaseValue(int amount) {
        this.value += amount;
    }
}
