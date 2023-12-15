package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.exceptions.FileProcessingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FileReaderUtilTest {

    @Test
    void processFile_withValidFile_processesLines() {
        @SuppressWarnings("unchecked")
        Consumer<String> lineProcessor = (Consumer<String>) Mockito.mock(Consumer.class);
        FileReaderUtil.processFile("day01/day01_input.txt", lineProcessor);

        verify(lineProcessor, atLeastOnce()).accept(anyString());
    }

    @Test
    void processFile_withInvalidFile_throwsException() {
        @SuppressWarnings("unchecked")
        Consumer<String> lineProcessor = (Consumer<String>) Mockito.mock(Consumer.class);
        assertThrows(FileProcessingException.class, () ->
                FileReaderUtil.processFile("invalid/path.txt", lineProcessor)
        );
    }

    @Test
    void processFile_withErrorDuringProcessing_throwsException() {
        @SuppressWarnings("unchecked")
        Consumer<String> lineProcessor = (Consumer<String>) Mockito.mock(Consumer.class);
        doThrow(RuntimeException.class).when(lineProcessor).accept(anyString());

        assertThrows(FileProcessingException.class, () ->
                FileReaderUtil.processFile("valid/path/to/file.txt", lineProcessor)
        );
    }
}
