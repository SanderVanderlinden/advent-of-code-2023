package com.sandervanderlinden.adventofcode2023.day10.pipe;

import static com.sandervanderlinden.adventofcode2023.day10.pipe.PipeForm.fromChar;

public class Pipe {

    private final PipeForm pipeForm;
    private final int xCoordinate;
    private final int yCoordinate;
    private Direction from;
    private Direction to;

    public Pipe(PipeForm pipeForm, int xCoordinate, int yCoordinate) {
        this.pipeForm = pipeForm;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Pipe(char c, int x, int y) {
        this(fromChar(c), x, y);
    }

    public Pipe(Pipe otherPipe) {
        this(otherPipe.pipeForm, otherPipe.xCoordinate, otherPipe.yCoordinate);
        this.from = otherPipe.from;
        this.to = otherPipe.to;
    }

    public PipeForm getPipeForm() {
        return pipeForm;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setFrom(Direction direction) {
        this.from = direction;
        setTo();
    }

    public Direction getTo() {
        return to;
    }


    public void setTo() {
        this.to = switch (pipeForm) {
            case NORTHEAST -> from == Direction.NORTH ? Direction.EAST : Direction.NORTH;
            case NORTHWEST -> from == Direction.NORTH ? Direction.WEST : Direction.NORTH;
            case SOUTHEAST -> from == Direction.SOUTH ? Direction.EAST : Direction.SOUTH;
            case SOUTHWEST -> from == Direction.SOUTH ? Direction.WEST : Direction.SOUTH;
            case HORIZONTAL -> from == Direction.EAST ? Direction.WEST : Direction.EAST;
            case VERTICAL -> from == Direction.NORTH ? Direction.SOUTH : Direction.NORTH;
            case START -> null;
        };
    }
}