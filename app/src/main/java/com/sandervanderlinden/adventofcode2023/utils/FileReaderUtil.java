package com.sandervanderlinden.adventofcode2023.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.ToIntFunction;

public class FileReaderUtil {

    public static int processFile(String filePath, ToIntFunction<String> lineProcessor) {
        InputStream inputStream = FileReaderUtil.class.getResourceAsStream(filePath);
        if (inputStream == null) {
            System.err.println("Input file not found");
            return 0;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().mapToInt(lineProcessor).sum();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}