package com.sandervanderlinden.adventofcode2023.day05.resources;

public record ResourceInterval(long start, long length) {

    public long getEnd() {
        return start + length;
    }
}