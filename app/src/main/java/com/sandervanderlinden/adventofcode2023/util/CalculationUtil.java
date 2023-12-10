package com.sandervanderlinden.adventofcode2023.util;

import com.sandervanderlinden.adventofcode2023.common.BasePuzzleSolver;

import java.util.logging.Logger;

public class CalculationUtil {

    private CalculationUtil() {
    }

    public static void calculateAndLogResult(BasePuzzleSolver solver, Logger logger, String filePath, Class<?> resultType) {
        Object result = solver.solve(filePath);
        logResult(result, resultType, logger);
    }

    static void logResult(Object result, Class<?> resultType, Logger logger) {
        if (resultType.isInstance(result)) {
            Object r = resultType.cast(result);
            String message = String.format("Result: %s", r);
            logger.info(message);
        }
        else {
            String message = "Unexpected result type: " + result.getClass().getSimpleName();
            logger.warning(message);
        }
    }
}
