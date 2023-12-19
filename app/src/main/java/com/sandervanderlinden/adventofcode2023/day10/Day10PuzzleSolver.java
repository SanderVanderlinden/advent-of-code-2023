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
    long loopLength = 1;
    private int lineIndex = 0;

    @Override
    public Object solve(String filePath) {
        pipeGrid = new Pipe[countCharsInFirstNonEmptyLine(filePath)][countLines(filePath)];
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
        createLoop();
        removeNonLoopElements();
        return solution();
    }

    void removeNonLoopElements() {
        for (int x = 0; x < pipeGrid.length; x++) {
            for (int y = 0; y < pipeGrid[x].length; y++) {
                Pipe pipe = pipeGrid[x][y];
                if (pipe != null && (pipe.getFrom() == null)){
                        pipeGrid[x][y] = null;

                }
            }
        }
    }

    void createLoop() {
        while (!pipeGrid[currentPipe.getXCoordinate()][currentPipe.getYCoordinate()].isStart()) {
            switch (currentPipe.getTo()) {
                case NORTH -> north();
                case EAST -> east();
                case SOUTH -> south();
                case WEST -> west();
            }
            loopLength++;
            currentPipe = new Pipe(nextPipe);
        }
    }

    abstract Object solution();

    void findFirstPipeAfterStart() {
        int x = currentPipe.getXCoordinate();
        int y = currentPipe.getYCoordinate();
        boolean foundEast = checkPipeForm(x + 1, y, PipeForm.NORTHWEST, PipeForm.HORIZONTAL, PipeForm.SOUTHWEST);
        boolean foundSouth = checkPipeForm(x, y + 1, PipeForm.NORTHEAST, PipeForm.VERTICAL, PipeForm.NORTHWEST);
        boolean foundWest = checkPipeForm(x - 1, y, PipeForm.NORTHEAST, PipeForm.HORIZONTAL, PipeForm.SOUTHEAST);


        //As at least 2 sides should be connected to the start pipe, there is no need to check the last side. One side will be found already by now.
        if (foundEast) {
            if (foundSouth) {
                currentPipe.setPipeForm(PipeForm.SOUTHEAST);
            }
            else if (foundWest) {
                currentPipe.setPipeForm(PipeForm.HORIZONTAL);
            }
            else {
                currentPipe.setPipeForm(PipeForm.NORTHEAST);
            }
            east();
        }
        else if (foundSouth) {
            if (foundWest) {
                currentPipe.setPipeForm(PipeForm.SOUTHWEST);
            }
            else {
                currentPipe.setPipeForm(PipeForm.VERTICAL);
            }
            south();
        }
        else {
            currentPipe.setPipeForm(PipeForm.NORTHWEST);
            west();
        }

        currentPipe = new Pipe(nextPipe);
        nextPipe.setFrom(currentPipe.getTo());
    }

    private boolean checkPipeForm(int x, int y, PipeForm... forms) {
        Pipe potentialNextPipe = pipeGrid[x][y];
        if (potentialNextPipe != null) {
            for (PipeForm form : forms) {
                if (potentialNextPipe.getPipeForm() == form) {
                    return true;
                }
            }
        }
        return false;
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
