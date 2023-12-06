# [Day 3: Gear Ratios](https://adventofcode.com/2023/day/3)

## --- Part One ---

### Problem Description

After reaching a gondola lift station with an Elf, you discover the gondolas aren't functioning due to a missing engine
part. To identify the missing part, you need to sum up all the part numbers in the engine schematic. The schematic
displays various numbers and symbols. A number is considered a part number if it's adjacent to a symbol (including
diagonally). Periods (.) do not count as symbols.

#### Example Engine Schematic

```467..114..
.........
..35..633.
......#...
617......
.....+.58.
..592.....
......755.
...$.*....
.664.598..
```

In this example, most numbers are part numbers except for 114 and 58. The sum of the part numbers is 4361.

#### Task

Calculate the sum of all the part numbers in the actual, larger engine schematic provided in your puzzle input.

## --- Part Two ---

### Problem Description

The missing part in the gondola lift engine has been found and installed, but there's still a problem. The gondola is moving too slowly, suggesting another issue with the engine. You discover that the problem lies in one of the gears. A gear in the engine schematic is represented by an asterisk (*) and is considered valid if it is adjacent to exactly two part numbers. The gear ratio is calculated by multiplying these two adjacent part numbers.

#### Task

Your new task is to find the gear ratio for every valid gear in the engine schematic and sum them up. This will help the engineer identify the faulty gear that needs replacement.

#### Example Engine Schematic

```
467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..
```

In this example, there are two valid gears:
- The first gear is adjacent to 467 and 35, resulting in a gear ratio of 16345.
- The second gear is adjacent to 598 and 664, resulting in a gear ratio of 451490.

The sum of these gear ratios is 467835.

#### Your Task

Calculate the sum of all the gear ratios in your actual, larger engine schematic provided in your puzzle input.

---

[← Back to Day 2](../day02/README.md) | [Go to Day 4 →](../day04/README.md)

