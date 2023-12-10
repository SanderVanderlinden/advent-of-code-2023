package com.sandervanderlinden.adventofcode2023.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineProcessingUtilityTest {


    @Test
    void testExtractNumbersAsStream() {
        String exampleLine = "1366623789 166330978 138490835 1175000149 927454202 5492211";
        List<Long> expected = List.of(1366623789L, 166330978L, 138490835L, 1175000149L, 927454202L, 5492211L);

        List<Long> actual = LineProcessingUtility.extractNumbersAsLongStream(exampleLine).toList();

        assertEquals(expected, actual, "The extracted numbers should match the expected list");
    }

    @Test
    void extractNumbersAsOneNumber() {
        String exampleLine = "Distance:  9  40  200";
        long expected = 940200L;

        long actual = LineProcessingUtility.extractNumbersAsOneNumber(exampleLine);

        assertEquals(expected, actual);
    }
}