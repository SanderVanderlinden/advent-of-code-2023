package com.sandervanderlinden.adventofcode2023.day10;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import com.sandervanderlinden.adventofcode2023.day10.pipe.Direction;
import com.sandervanderlinden.adventofcode2023.day10.pipe.Pipe;
import com.sandervanderlinden.adventofcode2023.day10.pipe.PipeForm;
import com.sandervanderlinden.adventofcode2023.util.FileReaderUtil;

import static com.sandervanderlinden.adventofcode2023.util.FileReaderUtil.countCharsInFirstNonEmptyLine;
import static com.sandervanderlinden.adventofcode2023.util.FileReaderUtil.countLines;

/**
 * Abstract class for solving Day 10 puzzles in the Advent of Code 2023.
 */
public abstract class Day10PuzzleSolver implements BasePuzzleSolver {

    Pipe[][] pipeGrid;
    Pipe currentPipe;
    Pipe nextPipe;
    private int lineIndex = 0;

    @Override
    public Object solve(String filePath) {
        pipeGrid = new Pipe[countLines(filePath)][countCharsInFirstNonEmptyLine(filePath)];
        FileReaderUtil.processFile(filePath, this::processLine);
        return finalizeSolver();
    }

    @Override
    public void processLine(String line) {
        for (int charIndex = 0; charIndex < line.length(); charIndex++) {
            char currentChar = line.charAt(charIndex);
            if (currentChar != '.') {
                pipeGrid[charIndex][lineIndex] = new Pipe(PipeForm.fromChar(currentChar), charIndex, lineIndex);
                if (currentChar == 'S') {
                    currentPipe = pipeGrid[charIndex][lineIndex];
                }
            }
        }
        lineIndex++;
    }

    @Override
    public Object finalizeSolver() {
        findFirstPipeAfterStart();
        long loopLength = 1;
        while (pipeGrid[currentPipe.getXCoordinate()][currentPipe.getYCoordinate()].getPipeForm() != PipeForm.START) {
            switch (currentPipe.getTo()) {
                case NORTH -> north();
                case EAST -> east();
                case SOUTH -> south();
                case WEST -> west();
            }
            loopLength++;
            currentPipe = new Pipe(nextPipe);
        }

        return loopLength / 2;
    }

    private void findFirstPipeAfterStart() {
        int x = currentPipe.getXCoordinate();
        int y = currentPipe.getYCoordinate();

        if (pipeGrid[x + 1][y].getPipeForm() == PipeForm.NORTHWEST) {
            east();
        }
        else if (pipeGrid[x + 1][y].getPipeForm() == PipeForm.HORIZONTAL) {
            east();
        }
        else if (pipeGrid[x + 1][y].getPipeForm() == PipeForm.SOUTHWEST) {
            east();
        }
        else if (pipeGrid[x][y + 1].getPipeForm() == PipeForm.NORTHEAST) {
            south();
        }
        else if (pipeGrid[x][y + 1].getPipeForm() == PipeForm.VERTICAL) {
            south();
        }
        else if (pipeGrid[x][y + 1].getPipeForm() == PipeForm.NORTHWEST) {
            south();
        }
        else if (pipeGrid[x - 1][y].getPipeForm() == PipeForm.SOUTHEAST) {
            west();
        }
        else if (pipeGrid[x - 1][y].getPipeForm() == PipeForm.HORIZONTAL) {
            west();
        }
        else if (pipeGrid[x - 1][y].getPipeForm() == PipeForm.NORTHEAST) {
            west();
        }
        //As at least 2 sides should be connected to the start pipe, there is no need to check the last side. One side will be found already by now.
        nextPipe.setFrom(currentPipe.getTo());
        currentPipe = new Pipe(nextPipe);
    }

    private void north() {
        nextPipe = pipeGrid[currentPipe.getXCoordinate()][currentPipe.getYCoordinate() - 1];
        nextPipe.setFrom(Direction.SOUTH);
    }

    private void east() {
        nextPipe = pipeGrid[currentPipe.getXCoordinate() + 1][currentPipe.getYCoordinate()];
        nextPipe.setFrom(Direction.WEST);
    }

    private void south() {
        nextPipe = pipeGrid[currentPipe.getXCoordinate()][currentPipe.getYCoordinate() + 1];
        nextPipe.setFrom(Direction.NORTH);
    }

    private void west() {
        nextPipe = pipeGrid[currentPipe.getXCoordinate() - 1][currentPipe.getYCoordinate()];
        nextPipe.setFrom(Direction.EAST);
    }
}
