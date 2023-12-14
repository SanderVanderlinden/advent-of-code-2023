package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class for processing lines of text with various string operations.
 */
public class LineProcessingUtility {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern NON_DIGIT_PATTERN = Pattern.compile("\\D+");
    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");
    private static final Pattern NON_LETTER_PATTERN = Pattern.compile("\\P{L}+");


    LineProcessingUtility() {
    }

    /**
     * Extracts the first digit found in a given string.
     *
     * @param line the string to search for digits
     * @return the first digit found as an integer
     * @throws NoDigitFoundException if no digit is found in the string
     */
    public static int extractFirstDigit(String line) throws NoDigitFoundException {
        Matcher matcher = DIGIT_PATTERN.matcher(line);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new NoDigitFoundException("No digits found in the line: " + line);
    }

    /**
     * Extracts the last digit found in a given string.
     *
     * @param line the string to search for digits
     * @return the last digit found as an integer
     * @throws NoDigitFoundException if no digit is found in the string
     */
    public static int extractLastDigit(String line) throws NoDigitFoundException {
        Matcher matcher = DIGIT_PATTERN.matcher(line);
        int lastDigit = -1;

        while (matcher.find()) {
            lastDigit = Integer.parseInt(matcher.group());
        }

        if (lastDigit != -1) {
            return lastDigit;
        }
        throw new NoDigitFoundException("No digits found in the line: " + line);
    }

    /**
     * Extracts all numbers from a string and returns them as a stream of longs.
     *
     * @param text the string to extract numbers from
     * @return a stream of longs representing the numbers found in the string
     */
    public static Stream<Long> extractNumbersAsLongStream(String text) {
        return NON_DIGIT_PATTERN.splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .map(Long::parseLong);
    }

    /**
     * Extracts all numbers from a string and concatenates them into a single long.
     *
     * @param text the string to extract numbers from
     * @return a long representing all concatenated numbers found in the string
     */
    public static long extractNumbersAsOneNumber(String text) {
        return Long.parseLong(NON_DIGIT_PATTERN.splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining()));
    }

    /**
     * Extracts all numbers from a string and returns them as a list of longs.
     *
     * @param text the string to extract numbers from
     * @return a list of longs representing the numbers found in the string
     */
    public static List<Long> extractNumbersAsList(String text) {
        return NON_DIGIT_PATTERN.splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .map(Long::parseLong)
                .toList();
    }

    /**
     * Converts a space-separated string into a list of strings.
     *
     * @param text the string to be split into a list
     * @return a list of strings, split by spaces
     */
    public static List<String> spaceSeparatedStringToList(String text) {
        return SPACE_PATTERN.splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .toList();
    }

    /**
     * Extracts all words from a string and returns them as a list of strings.
     *
     * @param text the string to extract words from
     * @return a list of strings representing the words found in the string
     */
    public static List<String> extractWordsAsList(String text) {
        return NON_LETTER_PATTERN.splitAsStream(text)
                .filter(str -> !str.isEmpty())
                .toList();
    }

    /**
     * Extracts lottery numbers from a line of the input file. Assumes the format includes a colon and a pipe symbol to separate the numbers.
     *
     * @param line A single line from the input file.
     * @return An array of two strings: the first element is the string of winning numbers,
     * and the second is the string of player's numbers.
     */
    public static Map<String, Set<Integer>> extractLotteryNumbers(String line) {
        Map<String, Set<Integer>> output = new HashMap<>();
        var numbersPart = line.substring(line.indexOf(":") + 1).trim();
        var numbersParts = numbersPart.split("\\|");
        output.put("winningNumbers", convertStringToIntegerSet(numbersParts[0]));
        output.put("ownNumbers", convertStringToIntegerSet(numbersParts[1]));
        return output;
    }

    /**
     * Converts a string of space-separated numbers into a Set of Integers.
     *
     * @param numberString A string containing numbers separated by spaces.
     * @return A Set of integers parsed from the input string.
     */
    public static Set<Integer> convertStringToIntegerSet(String numberString) {
        return Arrays.stream(numberString.split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
