
# [Day 10: Pipe Maze](https://adventofcode.com/2023/day/10)

## --- Part One ---

### Problem Description

After gliding to a floating metal island, you find a field packed with pipes and decide to sketch them. The pipes form a two-dimensional grid where each tile represents a different type of pipe or ground. Your task is to trace the pipe loop starting at the animal's position, S, and find the tile farthest from the starting position.

### Pipe Types

- `|`: Vertical pipe (north-south)
- `-`: Horizontal pipe (east-west)
- `L`, `J`, `7`, `F`: 90-degree bends
- `.`: Ground (no pipe)
- `S`: Starting position of the animal

### Example

A simple loop:
```
.....
.F-7.
.|.|.
.L-J.
.....
```

A more complex loop with additional pipes:
```
..F7.
.FJ|.
SJ.L7
|F--J
LJ...
```

### Task

Find the tile in the loop that is farthest from the starting position, measured by steps along the loop. Determine the maximum number of steps required to reach this point from the starting position.

---

[Placeholder for Part Two - Once details are provided, this section can be updated accordingly.]

---

[← Back to Day 9](../day09/README.md) | [Go to Day 11 →](../day11/README.md)
