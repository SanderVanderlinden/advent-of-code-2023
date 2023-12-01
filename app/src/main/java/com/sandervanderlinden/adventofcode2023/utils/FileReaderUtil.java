package com.sandervanderlinden.adventofcode2023.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.ToIntFunction;

public class FileReaderUtil {

    /**
     * Processes each line of the file specified by the filePath using the provided lineProcessor function.
     *
     * @param filePath      The path to the file to be processed.
     * @param lineProcessor A function to process each line of the file.
     * @return The sum of the processed values of each line.
     * @throws RuntimeException if there is an issue with file processing.
     */
    public static int processFile(String filePath, ToIntFunction<String> lineProcessor) {
        InputStream inputStream = FileReaderUtil.class.getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new RuntimeException("Input file not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().mapToInt(lineProcessor).sum();
        } catch (Exception e) {
            throw new RuntimeException("Error processing file: " + filePath, e);
        }
    }
}
