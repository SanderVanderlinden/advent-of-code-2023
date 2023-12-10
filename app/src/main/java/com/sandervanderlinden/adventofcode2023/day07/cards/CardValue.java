package com.sandervanderlinden.adventofcode2023.day07.cards;

public enum CardValue {
    TWO('2', 2), THREE('3', 3), FOUR('4', 4), FIVE('5', 5), SIX('6', 6), SEVEN('7', 7),
    EIGHT('8', 8), NINE('9', 9), TEN('T', 10), JACK('J', 11), QUEEN('Q', 12), KING('K', 13), ACE('A', 14);

    private final char symbol;
    private final int value;

    CardValue(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CardValue fromChar(char c) {
        for (CardValue cardValue : CardValue.values()) {
            if (cardValue.symbol == c) {
                return cardValue;
            }
        }
        throw new IllegalArgumentException("No card value for symbol: " + c);
    }
}
