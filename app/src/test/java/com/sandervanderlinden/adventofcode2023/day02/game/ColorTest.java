package com.sandervanderlinden.adventofcode2023.day02.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ColorTest {

    @Test
    void fromString_returnsCorrectColor() {
        assertEquals(Color.RED, Color.fromString("red"));
        assertEquals(Color.GREEN, Color.fromString("green"));
        assertEquals(Color.BLUE, Color.fromString("blue"));
    }

    @Test
    void fromString_withInvalidColor_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Color.fromString("yellow"));
    }
}