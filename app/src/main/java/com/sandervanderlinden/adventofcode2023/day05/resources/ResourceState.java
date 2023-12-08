package com.sandervanderlinden.adventofcode2023.day05.resources;

import java.util.ArrayDeque;
import java.util.Queue;

public class ResourceState {

    private final Queue<ResourceInterval> intervals;

    public ResourceState() {
        this.intervals = new ArrayDeque<>();
    }

    public void addInterval(ResourceInterval interval) {
        intervals.add(interval);
    }

    public Queue<ResourceInterval> getIntervals() {
        return intervals;
    }

}
