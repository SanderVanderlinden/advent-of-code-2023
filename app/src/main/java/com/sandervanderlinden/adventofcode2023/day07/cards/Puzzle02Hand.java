package com.sandervanderlinden.adventofcode2023.day07.cards;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Puzzle02Hand extends Hand {
    
    /**
     * Constructs a Hand with the given string representation of cards and a bid.
     *
     * @param cardsString the string representation of the cards
     * @param bid         the bid associated with this hand
     */
    public Puzzle02Hand(String cardsString, int bid) {
        super(cardsString, bid);
    }

    @Override
    public CardValue getCardValueForSymbolJ(){
        return CardValue.JOKER;
    }

    @Override
    public int getType() {
        EnumMap<CardValue, Integer> cardOccurrences = getSortedOccurrencesMap();
        List<Integer> getTwoMostFrequentCards = getTwoMostFrequentNoJokerCards(cardOccurrences);
        int amountOfJokers = cardOccurrences.getOrDefault(CardValue.JOKER, 0);

        int mostOccurringCardAmount = getTwoMostFrequentCards.isEmpty() ? 0 : Math.toIntExact(getTwoMostFrequentCards.get(0));
        int secondMostOccurringCardAmount = getTwoMostFrequentCards.size() > 1 ? Math.toIntExact(getTwoMostFrequentCards.get(1)) : 0;

        return switch (mostOccurringCardAmount + amountOfJokers) {
            case 5 -> 7; // Five of a kind
            case 4 -> 6; // Four of a kind
            case 3 -> (secondMostOccurringCardAmount == 2) ? 5 : 4; // Full house or Three of a kind
            case 2 -> (secondMostOccurringCardAmount == 2) ? 3 : 2; // Two pair or One pair
            default -> 1; // High card
        };
    }

    /**
     * Gets the two most frequently occurring card values in this hand.
     *
     * @return a List of the two most frequently occurring CardValues, or fewer if not enough unique cards.
     */
    List<Integer> getTwoMostFrequentNoJokerCards(EnumMap<CardValue, Integer> cardOccurrences) {
        return cardOccurrences.entrySet().stream()
                .filter(entry -> entry.getKey() != CardValue.JOKER)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .map(Map.Entry::getValue)
                .toList();
    }
}
