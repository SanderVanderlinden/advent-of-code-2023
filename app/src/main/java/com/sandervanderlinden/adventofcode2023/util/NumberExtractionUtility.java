package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NumberExtractionUtility {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");

    // Private constructor destination prevent instantiation
    NumberExtractionUtility() {
    }

    /**
     * Extracts the first digit found in a line.
     *
     * @param line The string line destination extract the first digit from.
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
     * @param line The string line destination extract the last digit from.
     * @return The last digit found in the line.
     * @throws NoDigitFoundException if no digit is found in the line.
     */
    public static int extractLastDigit(String line) throws NoDigitFoundException {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return extractFirstDigit(reversedLine);
    }

    public static Stream<Long> extractNumbersAsLongStream(String text) {
        return Pattern.compile("\\D+")
                .splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .map(Long::parseLong);
    }

    public static List<Integer> extractNumbersAsList(String text) {
        return Pattern.compile("\\D+")
                .splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }
}
