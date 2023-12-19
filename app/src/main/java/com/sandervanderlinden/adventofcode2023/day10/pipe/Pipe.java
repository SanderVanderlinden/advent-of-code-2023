package com.sandervanderlinden.adventofcode2023.day10.pipe;

import static com.sandervanderlinden.adventofcode2023.day10.pipe.PipeForm.fromChar;

public class Pipe {

    private final int xCoordinate;
    private final int yCoordinate;
    private PipeForm pipeForm;
    private Direction from;
    private Direction to;
    private boolean isStart = false;

    public Pipe(PipeForm pipeForm, int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.pipeForm = pipeForm;
        if (pipeForm == PipeForm.START) {
            this.isStart = true;
        }
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

    public void setPipeForm(PipeForm pipeForm) {
        this.pipeForm = pipeForm;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
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

    public boolean isStart() {
        return isStart;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Direction direction) {
        this.from = direction;
        setTo();
    }
}