package com.sandervanderlinden.adventofcode2023.day03.schematic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SymbolTest {

    @Test
    void testEquals() {
        Symbol symbol1 = new Symbol(1);
        Symbol symbol2 = new Symbol(1);
        Symbol symbolDifferentPosition = new Symbol(2);

        assertEquals(symbol1, symbol1);
        assertEquals(symbol1, symbol2);
        assertNotEquals(symbol1, symbolDifferentPosition);
        assertNotEquals(null, symbol1);
        assertNotEquals(symbol1, new Object());
    }
}