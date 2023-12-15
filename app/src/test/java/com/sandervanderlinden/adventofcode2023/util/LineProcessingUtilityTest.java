package com.sandervanderlinden.adventofcode2023.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LineProcessingUtilityTest {

    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<LineProcessingUtility> constructor = LineProcessingUtility.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));

        constructor.setAccessible(true);
        assertNotNull(constructor.newInstance());
    }

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

    @Test
    void extractLotteryNumbers() {
        String exampleLine = "Card   1: 69 24 51 87  9 49 17 16 21 48 |  5 52 86 35 57 18 60 84 50 76 96 47 38 41 34 36 55 20 25 37  6 70 66 45  3\n";
        Map<String, Set<Integer>> expected = new HashMap<>();
        expected.put("winningNumbers", Set.of(16, 48, 49, 17, 51, 69, 21, 87, 24, 9));
        expected.put("ownNumbers", Set.of(66, 3, 5, 6, 70, 76, 18, 84, 20, 86, 25, 96, 34, 35, 36, 37, 38, 41, 45, 47, 50, 52, 55, 57, 60));

        Map<String, Set<Integer>> actual = LineProcessingUtility.extractLotteryNumbers(exampleLine);

        assertEquals(expected, actual);
    }

    @Test
    void extractNumbersAsList_withNoEmptyStrings() {
        List<Long> result = LineProcessingUtility.extractNumbersAsList("12 34 56");
        assertEquals(Arrays.asList(12L, 34L, 56L), result);
    }

    @Test
    void extractNumbersAsList_withEmptyStrings() {
        List<Long> result = LineProcessingUtility.extractNumbersAsList("12  34   56");
        assertEquals(Arrays.asList(12L, 34L, 56L), result);
    }
}