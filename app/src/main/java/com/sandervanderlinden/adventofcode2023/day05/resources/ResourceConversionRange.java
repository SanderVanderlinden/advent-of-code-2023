package com.sandervanderlinden.adventofcode2023.day05.resources;

public record ResourceConversionRange(long source, long destination, long length) {

    public long getSourceEnd() {
        return source + length;
    }
    public long getSourceDestinationDifference() {
        return destination - source;
    }
}