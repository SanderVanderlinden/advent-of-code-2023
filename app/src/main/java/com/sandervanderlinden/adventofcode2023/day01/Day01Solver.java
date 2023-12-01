package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NoDigitFoundException("No digits found in the line: " + line);
    }

    int extractLastDigit(String line) {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return extractFirstDigit(reversedLine);
    }
}
