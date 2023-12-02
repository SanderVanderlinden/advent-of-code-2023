# [Day 2: Cube Conundrum](https://adventofcode.com/2023/day/2)

## --- Part One ---

### Problem Description

After a high-flying journey, you land on Snow Island. An Elf there introduces you to a game with red, green, and blue
cubes. The cubes are hidden in a bag, and your challenge is to deduce information about their number based on the
subsets of cubes revealed.
Your task is to figure out which games could have been possible if the bag contained only 12 red cubes, 13 green cubes,
and 14 blue cubes. Sum the IDs of the games that meet this criteria.

### Example

- `Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green`
- `Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue`
- `Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red`
- `Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red`
- `Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green`

**Explanation:**

- Games 1, 2, and 5 are possible with the constraints (12 red, 13 green, 14 blue cubes).
    - In Game 1, the maximum shown at once is 6 blue cubes, which fits within the limit.
    - In Game 2, the highest is 4 blue cubes, which also fits.
    - Game 5 shows at most 6 red cubes at once.
- Games 3 and 4 are impossible:
    - Game 3 shows 20 red cubes at once, exceeding the 12 red cube limit.
    - Game 4 shows 15 blue cubes at a time, going over the 14 blue cube limit.

### Task

Identify and calculate the sum of the IDs of the possible games given the constraints on the number of cubes.


---

[← Back to Day 1](../day01/README.md) | [Go to Day 3 →](../day03/README.md)
