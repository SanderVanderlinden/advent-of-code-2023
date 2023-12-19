package com.sandervanderlinden.adventofcode2023.day10.pipe;

public enum PipeForm {

    NORTHEAST('L'),
    NORTHWEST('J'),
    SOUTHEAST('F'),
    SOUTHWEST('7'),
    HORIZONTAL('-'),
    VERTICAL('|'),
    START('S');

    private final char symbol;

    PipeForm(char symbol) {
        this.symbol = symbol;
    }

    public static PipeForm fromChar(char c) {
        for (PipeForm pipeForm : PipeForm.values()) {
            if (pipeForm.symbol == c) {
                return pipeForm;
            }
        }
        throw new IllegalArgumentException("No pipeForm value for symbol: " + c);
    }
}
