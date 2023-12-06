package com.sandervanderlinden.adventofcode2023.utils;

import com.sandervanderlinden.adventofcode2023.exceptions.FileProcessingException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.ToIntFunction;

/**
 * Utility class for processing files.
 * This class reads files from the classpath and processes their contents line by line.
 */
public class FileReaderUtil {

    // Private constructor to prevent instantiation
    private FileReaderUtil() {
    }

    /**
     * Processes each line of the file located at the given classpath resource using the provided lineProcessor function.
     * The method reads the file as a stream, applies the processing function to each line, and sums up the results.
     *
     * @param filePath      The classpath resource path to the file to be processed.
     * @param lineProcessor A function to process each line of the file. It should take a String (line) as input and return an int.
     * @return The sum of the processed values for each line in the file.
     * @throws FileProcessingException if there is an issue with accessing or processing the file.
     */
    public static int processFile(String filePath, ToIntFunction<String> lineProcessor) {
        InputStream inputStream = FileReaderUtil.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new FileProcessingException("Input file not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().mapToInt(lineProcessor).sum();
        } catch (Exception e) {
            throw new FileProcessingException("Error processing file: " + filePath, e);
        }
    }
}
