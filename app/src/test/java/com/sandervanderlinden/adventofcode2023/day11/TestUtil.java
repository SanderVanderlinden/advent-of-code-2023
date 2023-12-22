package com.sandervanderlinden.adventofcode2023.day11;

import com.sandervanderlinden.adventofcode2023.day11.galaxy.Galaxy;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Galaxy> ListRepresentingTestImage() {
        List<Galaxy> output = new ArrayList<>();
        output.add(new Galaxy(4, 0));
        output.add(new Galaxy(9, 1));
        output.add(new Galaxy(0, 2));
        output.add(new Galaxy(8, 5));
        output.add(new Galaxy(1, 6));
        output.add(new Galaxy(12, 7));
        output.add(new Galaxy(9, 10));
        output.add(new Galaxy(0, 11));
        output.add(new Galaxy(5, 11));
        return output;
    }
}
