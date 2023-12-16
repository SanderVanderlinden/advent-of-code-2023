# [Day 7: Camel Cards](https://adventofcode.com/2023/day/7)

## --- Part One ---

### Problem Description

You learn Camel Cards, a game similar to poker, while traveling across Desert Island. The game involves ordering hands of cards based on their strength, with each hand consisting of five cards labeled from A (highest) to 2 (lowest).

### Hand Types

- **Five of a Kind**: All five cards have the same label (e.g., AAAAA).
- **Four of a Kind**: Four cards have the same label and one different (e.g., AA8AA).
- **Full House**: Three cards have the same label, and the remaining two share a different label (e.g., 23332).
- **Three of a Kind**: Three cards have the same label, and the remaining two are different (e.g., TTT98).
- **Two Pair**: Two cards share one label, two others share a second label, and one different (e.g., 23432).
- **One Pair**: Two cards share one label, and the other three are different (e.g., A23A4).
- **High Card**: All cards' labels are distinct (e.g., 23456).

### Example

Given hands and their bids:
- 32T3K 765
- T55J5 684
- KK677 28
- KTJJT 220
- QQQJA 483

Order the hands by strength and calculate the total winnings based on their bids and ranks.

### Task

Find the rank of every hand in your set and calculate the total winnings.

---

## --- Part Two ---

### Additional Rule: Jokers

J cards are now jokers or wildcards, the weakest individual cards, but can act as any card to make the hand the strongest type possible.

### Modified Example

With the joker rule, hands like QJJQ2 are considered four of a kind, but J is treated as the weakest card for tie-breaking.

### Modified Task

Re-rank the hands with the joker rule and calculate the new total winnings.

---

[← Back to Day 6](../day06/README.md) | [Go to Day 8 →](../day08/README.md)