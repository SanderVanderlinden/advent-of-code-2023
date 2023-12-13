
# [Day 8: Haunted Wasteland](https://adventofcode.com/2023/day/8)

## --- Part One ---

### Problem Description

Caught in a sandstorm on Desert Island, you find a set of maps and instructions to navigate a network of labeled nodes. The objective is to follow left/right instructions to move from node AAA to ZZZ.

### Network Example

- Instructions: RL
- Nodes:
  - AAA = (BBB, CCC)
  - BBB = (DDD, EEE)
  - CCC = (ZZZ, GGG)
  - DDD = (DDD, DDD)
  - EEE = (EEE, EEE)
  - GGG = (GGG, GGG)
  - ZZZ = (ZZZ, ZZZ)

Follow the instructions, repeating them if necessary, to reach ZZZ.

### Task

Determine the number of steps required to reach ZZZ.

---

## --- Part Two ---

### Enhanced Challenge: Ghost Navigation

Reinterpreting the maps for ghost navigation, you realize you must start at every node ending with A and follow the paths until all paths end at nodes ending with Z.

### Enhanced Example

- Instructions: LR
- Nodes:
  - 11A = (11B, XXX)
  - 11B = (XXX, 11Z)
  - 11Z = (11B, XXX)
  - 22A = (22B, XXX)
  - 22B = (22C, 22C)
  - 22C = (22Z, 22Z)
  - 22Z = (22B, 22B)
  - XXX = (XXX, XXX)

Simultaneously navigate from all A-ending nodes and track the number of steps until only Z-ending nodes are reached.

### Enhanced Task

Calculate the steps required until you're only on nodes that end with Z.

---

[← Back to Day 7](../day07/README.md) | [Go to Day 9 →](../day09/README.md)
