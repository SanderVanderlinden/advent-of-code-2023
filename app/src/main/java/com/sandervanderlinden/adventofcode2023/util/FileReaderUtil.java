package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.exceptions.FileProcessingException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class FileReaderUtil {

    private FileReaderUtil() {
    }

    public static void processFile(String filePath, Consumer<String> lineProcessor) {
        InputStream inputStream = FileReaderUtil.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new FileProcessingException("Input file not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            reader.lines().forEach(lineProcessor);
        } catch (Exception e) {
            throw new FileProcessingException("Error processing file: " + filePath, e);
        }
    }
}
