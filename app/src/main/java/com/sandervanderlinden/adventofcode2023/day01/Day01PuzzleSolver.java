package com.sandervanderlinden.adventofcode2023.day01;

import com.sandervanderlinden.adventofcode2023.exceptions.NoDigitFoundException;

interface Day01PuzzleSolver {
    int extractAndCombineDigits(String line);
    int extractFirstDigit(String line) throws NoDigitFoundException;
    int extractLastDigit(String line);
}