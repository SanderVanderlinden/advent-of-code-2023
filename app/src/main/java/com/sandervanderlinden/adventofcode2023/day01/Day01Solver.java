package com.sandervanderlinden.adventofcode2023.day01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Day01Solver {
    public static void main(String[] args) {
        InputStream inputStream = Day01Solver.class.getResourceAsStream("/day01/day01_input.txt");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            reader.lines().forEach(System.out::println);
        } else {
            System.err.println("Input file not found");
        }
    }

    public int extractAndSumNumbers(String line) {
        return 0;
    }
}
