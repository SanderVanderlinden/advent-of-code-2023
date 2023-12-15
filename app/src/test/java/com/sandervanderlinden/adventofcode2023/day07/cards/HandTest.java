package com.sandervanderlinden.adventofcode2023.day07.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void testEquals() {
        Hand hand = new Puzzle01Hand("AAAAA", 10);
        Hand handEqual = new Puzzle01Hand("AAAAA", 10);
        Hand handDifferent = new Puzzle01Hand("KKKKK", 10);

        assertEquals(hand, hand);
        assertEquals(hand, handEqual);
        assertNotEquals(hand, handDifferent);
        assertNotEquals(null, hand);
        assertNotEquals(hand, new Object());
    }

    @Test
    void testCompareTo() {
        Hand hand = new Puzzle01Hand("AAAAA", 10);
        Hand handEqual = new Puzzle01Hand("AAAAA", 10);
        Hand handDifferent = new Puzzle01Hand("KKKKK", 10);
        Hand handDifferent2 = new Puzzle01Hand("34567", 10);
        assertEquals(0, hand.compareTo(handEqual));
        assertEquals(1, hand.compareTo(handDifferent));
        assertEquals(-1, handDifferent.compareTo(hand));
        assertEquals(1, hand.compareTo(handDifferent2));
        assertEquals(-1, handDifferent2.compareTo(hand));
    }

    @Test
    void testHashCode() {
        Hand hand = new Puzzle01Hand("AAAAA", 10);
        Hand handEqual = new Puzzle01Hand("AAAAA", 10);
        Hand handDifferent = new Puzzle01Hand("KKKKK", 10);

        assertEquals(hand.hashCode(), handEqual.hashCode());
        assertNotEquals(hand.hashCode(), handDifferent.hashCode());
        assertThrows(IllegalArgumentException.class, () -> new Puzzle01Hand("QSDFG", 10));
    }

    @Test
    void testToString() {
        Hand hand = new Puzzle01Hand("AAKAA", 10);
        String expected = "Hand{cards=[ACE, ACE, KING, ACE, ACE], bid=10, type=6}";
        assertEquals(expected, hand.toString());
    }

    @Test
    void testCardValueThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> new Puzzle01Hand("ZZZZZ", 10));
    }

    @Test
    void getType_ReturnsCorrectTypeBasedOnCardOccurrences() {
        Hand hand = new Puzzle01Hand("22233", 10);
        int type = hand.getType();
        int expectedType = 5;
        assertEquals(expectedType, type);
    }
}
