package com.sandervanderlinden.adventofcode2023.day07.cards;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards in the game.
 * Each hand consists of five cards and is associated with a bid.
 */
public class Hand implements Comparable<Hand> {
    private final CardValue[] cards = new CardValue[5];
    private final int bid;

    /**
     * Constructs a Hand with the given string representation of cards and a bid.
     *
     * @param cardsString the string representation of the cards
     * @param bid         the bid associated with this hand
     */
    public Hand(String cardsString, int bid) {
        setCardsFromString(cardsString);
        this.bid = bid;
    }

    /**
     * Returns the bid associated with this hand.
     *
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * Sets the cards in this hand based on a string representation.
     *
     * @param cardsString the string representation of the cards
     */
    private void setCardsFromString(String cardsString) {
        for (int i = 0; i < 5; i++) {
            cards[i] = CardValue.fromChar(cardsString.charAt(i));
        }
    }

    /**
     * Compares this hand with another hand for order.
     * Hands are first compared based on their type, and then by individual card values.
     *
     * @param other the hand to be compared
     * @return a negative integer, zero, or a positive integer as this hand
     * is less than, equal to, or greater than the specified hand
     */
    @Override
    public int compareTo(Hand other) {
        int typeComparison = Integer.compare(this.getType(), other.getType());
        if (typeComparison != 0) {
            return typeComparison;
        }

        for (int i = 0; i < 5; i++) {
            int cardComparison = Integer.compare(this.cards[i].getValue(), other.cards[i].getValue());
            if (cardComparison != 0) {
                return cardComparison;
            }
        }

        return 0;
    }

    /**
     * Indicates whether some other object is "equal to" this hand.
     * Hands are considered equal if they have the same type and the same card values.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Hand otherHand = (Hand) obj;
        return this.compareTo(otherHand) == 0;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (CardValue card : cards) {
            result = 31 * result + (card != null ? card.hashCode() : 0);
        }
        return result;
    }


    /**
     * Determines the type of this hand based on the rules of the game.
     * The type is determined by the occurrences of card values.
     *
     * @return an integer representing the type of the hand
     */
    private int getType() {
        List<Long> cardOccurrences = getSortedOccurrencesList();

        int mostOccurringCardAmount = cardOccurrences.isEmpty() ? 0 : Math.toIntExact(cardOccurrences.get(0));
        int secondMostOccurringCardAmount = cardOccurrences.size() > 1 ? Math.toIntExact(cardOccurrences.get(1)) : 0;

        return switch (mostOccurringCardAmount) {
            case 5 -> 7; // Five of a kind
            case 4 -> 6; // Four of a kind
            case 3 -> (secondMostOccurringCardAmount == 2) ? 5 : 4; // Full house or Three of a kind
            case 2 -> (secondMostOccurringCardAmount == 2) ? 3 : 2; // Two pair or One pair
            default -> 1; // High card
        };
    }

    /**
     * Gets a sorted list of the occurrences of each card value in this hand.
     * The list is sorted in descending order based on the number of occurrences.
     *
     * @return a sorted list of occurrences
     */
    private List<Long> getSortedOccurrencesList() {
        return Arrays.stream(cards)
                .collect(Collectors.groupingBy(card -> card, Collectors.counting()))
                .values()
                .stream()
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .toList();
    }

}
