
# [Day 5: If You Give A Seed A Fertilizer](https://adventofcode.com/2023/day/5)

## --- Part One ---

### Problem Description

You're assisting a gardener at Island Island with their food production problem. The Island Island Almanac contains complex mappings of seeds to soils, fertilizers, water, light, temperature, humidity, and locations. Each item is identified by a number, but numbers are reused across categories.

### Example

- Seeds: 79 14 55 13
- Seed-to-soil map:
  - 50 98 2
  - 52 50 48
- [Continued with soil-to-fertilizer map, fertilizer-to-water map, etc.]

Maps convert numbers from a source category to a destination category. Your task is to find the lowest location number corresponding to any initial seed number.

### Task

Determine the lowest location number that corresponds to any of the initial seed numbers.

---

## --- Part Two ---

### Problem Description

The initial 'seeds:' line in the almanac describes ranges of seed numbers, not individual seeds. Each pair of values in this line represents the start of a range and the length of the range.

### Example

- Seeds: 79 14 55 13
  - This describes two ranges: 79-92 and 55-67.

The task now is to consider all seed numbers in these ranges and find the lowest location number corresponding to any of these seeds.

### Task

Determine the lowest location number that corresponds to any of the initial seed numbers listed in the ranges on the first line of the almanac.

---

[← Back to Day 4](../day04/README.md) | [Go to Day 6 →](../day06/README.md)
