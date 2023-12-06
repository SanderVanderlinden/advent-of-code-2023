package com.sandervanderlinden.adventofcode2023.utils;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitExtractionUtility {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");

    // Private constructor to prevent instantiation
    private DigitExtractionUtility() {
    }

    /**
     * Extracts the first digit found in a line.
     *
     * @param line The string line to extract the first digit from.
     * @return The first digit found in the line.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    public static int extractFirstDigit(String line) throws NoDigitFoundException {
        Matcher matcher = DIGIT_PATTERN.matcher(line);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NoDigitFoundException("No digits found in the line: " + line);
    }

    /**
     * Extracts the last digit found in a line.
     *
     * @param line The string line to extract the last digit from.
     * @return The last digit found in the line.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    public static int extractLastDigit(String line) throws NoDigitFoundException {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return extractFirstDigit(reversedLine);
    }
}
