package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class CalculationUtilTest {

    @Test
    void testLogResultWithExpectedType() {
        Logger mockLogger = mock(Logger.class);
        Object result = "Test Result";
        Class<?> resultType = String.class;

        CalculationUtil.logResult(result, resultType, mockLogger);

        verify(mockLogger).info("Result: Test Result");
    }

    @Test
    void testLogResultWithUnexpectedType() {
        Logger mockLogger = mock(Logger.class);
        Object result = 123;
        Class<?> resultType = String.class;

        CalculationUtil.logResult(result, resultType, mockLogger);

        verify(mockLogger).warning("Unexpected result type: Integer");
    }

    @Test
    void testCalculateAndLogResult() {
        BasePuzzleSolver mockSolver = mock(BasePuzzleSolver.class);
        Logger mockLogger = mock(Logger.class);
        String filePath = "test/path";
        Class<?> resultType = String.class;

        when(mockSolver.solve(filePath)).thenReturn("Expected Result");

        CalculationUtil.calculateAndLogResult(mockSolver, mockLogger, filePath, resultType);

        verify(mockLogger).info("Result: Expected Result");
    }
}