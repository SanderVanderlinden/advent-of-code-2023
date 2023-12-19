package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.exceptions.FileProcessingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.function.Function;

public class FileReaderUtil {

    private FileReaderUtil() {
    }

    public static void processFile(String filePath, Consumer<String> lineProcessor) {
        processFileWithFunction(filePath, reader -> {
            try {
                reader.lines().forEach(lineProcessor);
            } catch (UncheckedIOException e) {
                throw new FileProcessingException("Error processing file: " + filePath, e.getCause());
            }
            return null;
        });
    }

    public static int countLines(String filePath) {
        return processFileWithFunction(filePath, reader -> {
            int lineCount = 0;
            try {
                while (reader.readLine() != null) {
                    lineCount++;
                }
            } catch (IOException e) {
                throw new FileProcessingException("Error reading file: " + filePath, e);
            }
            return lineCount;
        });
    }

    public static int countCharsInFirstNonEmptyLine(String filePath) {
        return processFileWithFunction(filePath, reader -> {
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        return line.length();
                    }
                }
            } catch (IOException e) {
                throw new FileProcessingException("Error reading file: " + filePath, e);
            }
            return 0;
        });
    }

    private static <T> T processFileWithFunction(String filePath, Function<BufferedReader, T> function) {
        InputStream inputStream = FileReaderUtil.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new FileProcessingException("Input file not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return function.apply(reader);
        } catch (IOException e) {
            throw new FileProcessingException("Error processing file: " + filePath, e);
        }
    }
}
