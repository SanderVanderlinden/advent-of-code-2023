# [Day 1: Trebuchet?!](https://adventofcode.com/2023/day/1)

## --- Part One ---

### Problem Description

Global snow production is facing issues, and the Elves need your help. They've marked fifty critical locations on a map
where problems need to be addressed. The goal is to check all fifty stars by December 25th. The calibration document
provided for adjusting the trebuchet has been inadvertently altered by a young Elf. The challenge involves recovering
calibration values from each line of the document, formed by combining the first and last digits into a two-digit
number.

### Example

- `1abc2` results in `12`
- `pqr3stu8vwx` results in `38`
- `a1b2c3d4e5f` results in `15`
- `treb7uchet` results in `77`

Adding these together produces a total of `142`.

### Task

Consider your entire calibration document. What is the sum of all of the calibration values?

## --- Part Two ---

In the second part of the puzzle, it's discovered that some digits are spelled out with letters. The task is to find the
real first and last digit on each line, considering these textual representations, and sum them up.

### Example

- `two1nine` -> `29`
- `eightwothree` -> `83`
- `abcone2threexyz` -> `13`
- `xtwone3four` -> `24`
- `4nineeightseven2` -> `42`
- `zoneight234` -> `14`
- `7pqrstsixteen` -> `76`

In this example, the sum of the calibration values is `281`.

### Task

Determine the sum of all the real calibration values considering the spelled-out digits.

---

[Go to Day 2 →](../day02/README.md)