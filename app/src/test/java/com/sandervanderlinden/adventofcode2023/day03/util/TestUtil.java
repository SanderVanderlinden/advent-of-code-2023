package com.sandervanderlinden.adventofcode2023.day03.util;

import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Symbol;

import java.util.HashSet;
import java.util.Set;

public class TestUtil {


    public static Set<SchematicToken> createEmptySchematicTokenSet() {
        return new HashSet<>();
    }

    public static String lineContainingSymbols() {
        return "*......+.....;";
    }

    public static Set<SchematicToken> createSetForLineContainingSymbols() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(new Symbol(0));
        tokens.add(new Symbol(7));
        tokens.add(new Symbol(13));
        return tokens;
    }

    public static String lineContainingDigits() {
        return "8......6.....3";
    }

    public static Set<SchematicToken> createSetForLineContainingDigits() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(new Number(0, 8));
        tokens.add(new Number(7, 6));
        tokens.add(new Number(13, 3));
        return tokens;
    }

    public static String lineContainingNumbers() {
        return "885......665.....335";
    }

    public static Set<SchematicToken> createSetForLineContainingNumbers() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(new Number(0, 885));
        tokens.add(new Number(9, 665));
        tokens.add(new Number(17, 335));
        return tokens;
    }

    public static String lineContainingEverything() {
        return ".885...@4788.*6...7-...8.*..335-";
    }

    public static Set<SchematicToken> createSetForLineContainingEverything() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(createMultipleDigitsNumberWithNoAdjacentTokens());
        tokens.add(new Symbol(7));
        tokens.add(createMultipleDigitsWithAdjacentTokenToTheLeft());
        tokens.add(new Symbol(13));
        tokens.add(createSingleDigitNumberWithAdjacentTokenToTheLeft());
        tokens.add(createSingleDigitNumberWithAdjacentTokenToTheRight());
        tokens.add(new Symbol(19));
        tokens.add(createSingleDigitNumberWithNoAdjacentTokens());
        tokens.add(new Symbol(25));
        tokens.add(createMultipleDigitsWithAdjacentTokenToTheRight());
        tokens.add(new Symbol(31));
        return tokens;
    }

    public static Number createSingleDigitNumberWithNoAdjacentTokens() {
        return new Number(23, 8);
    }

    public static Number createSingleDigitNumberWithAdjacentTokenToTheLeft() {
        return new Number(14, 6);
    }

    public static Number createSingleDigitNumberWithAdjacentTokenToTheRight() {
        return new Number(18, 7);
    }

    public static Number createMultipleDigitsNumberWithNoAdjacentTokens() {
        return new Number(1, 885);
    }

    public static Number createMultipleDigitsWithAdjacentTokenToTheLeft() {
        return new Number(8, 4788);
    }

    public static Number createMultipleDigitsWithAdjacentTokenToTheRight() {
        return new Number(28, 335);
    }

    public static Number createSingleDigitNumberWithAdjacentTokenOnTheSameIndex() {
        return new Number(25, 1);
    }

    public static Number createMultipleDigitsNumberWithAdjacentTokenOnTheSameIndex() {
        return new Number(24, 5875);
    }
}
