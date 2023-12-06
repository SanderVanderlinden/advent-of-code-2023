
# [Day 4: Scratchcards](https://adventofcode.com/2023/day/4)

## --- Part One ---

### Problem Description

You arrive at Island Island via gondola and meet an Elf with a pile of colorful scratchcards. Each card has two lists of numbers separated by a vertical bar (|): a list of winning numbers and then a list of numbers you have. The task is to figure out which of the numbers you have appear in the list of winning numbers. The first match makes the card worth one point, and each subsequent match doubles the card's point value.

### Example

- Card 1: `41 48 83 86 17 | 83 86 6 31 17 9 48 53`
- Card 2: `13 32 20 16 61 | 61 30 68 82 17 32 24 19`
- Card 3: `1 21 53 59 44 | 69 82 63 72 16 21 14 1`
- Card 4: `41 92 73 84 69 | 59 84 76 51 58 5 54 83`
- Card 5: `87 83 26 28 32 | 88 30 70 12 93 22 82 36`
- Card 6: `31 18 13 56 72 | 74 77 10 23 35 67 36 11`

In this example, the total points from the scratchcards are 13.

### Task

Determine the total points value of all the scratchcards in the Elf's pile.

---

## --- Part Two ---

### Problem Description

As you're about to report your findings to the Elf, you discover that the scratchcards operate differently than initially thought. Instead of points, scratchcards allow you to win more scratchcards equal to the number of matching numbers. Each card wins copies of the scratchcards below it equal to the number of matches. Copies are scored like normal scratchcards and can win more cards in a cascading effect. The process repeats until no more scratchcards are won.

### Example

- Card 1: `41 48 83 86 17 | 83 86 6 31 17 9 48 53`
- Card 2: `13 32 20 16 61 | 61 30 68 82 17 32 24 19`
- Card 3: `1 21 53 59 44 | 69 82 63 72 16 21 14 1`
- Card 4: `41 92 73 84 69 | 59 84 76 51 58 5 54 83`
- Card 5: `87 83 26 28 32 | 88 30 70 12 93 22 82 36`
- Card 6: `31 18 13 56 72 | 74 77 10 23 35 67 36 11`

In this system, the total number of scratchcards ultimately ends up being 30.

### Task

Process all of the original and copied scratchcards following the new rules. Calculate how many total scratchcards you end up with, including the original set.

---

[← Back to Day 3](../day03/README.md) | [Go to Day 5 →](../day05/README.md)
