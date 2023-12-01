package com.sandervanderlinden.adventofcode2023.day01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Day01Solver {
    public static void main(String[] args) {
        InputStream inputStream = Day01Solver.class.getResourceAsStream("/day01/day01_input.txt");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Day01Solver solver = new Day01Solver();
            int sum = reader.lines()
                    .mapToInt(solver::extractAndSumDigits)
                    .sum();
            System.out.println("Total sum: " + sum);
        } else {
            System.err.println("Input file not found");
        }
    }

    public int extractAndSumDigits(String line) {
        int firstNumber = extractFirstDigit(line);
        int lastNumber = extractLastDigit(line);
        return firstNumber + lastNumber;
    }

    int extractFirstDigit(String line) {
        return 0;
    }

    int extractLastDigit(String line) {
        return 0;
    }

}
