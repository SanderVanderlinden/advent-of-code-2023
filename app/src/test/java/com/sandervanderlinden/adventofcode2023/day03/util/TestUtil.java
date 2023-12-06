package com.sandervanderlinden.adventofcode2023.day03.util;

import com.sandervanderlinden.adventofcode2023.day03.Day03Puzzle02Solver;
import com.sandervanderlinden.adventofcode2023.day03.schematic.GearSymbol;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Number;
import com.sandervanderlinden.adventofcode2023.day03.schematic.SchematicToken;
import com.sandervanderlinden.adventofcode2023.day03.schematic.Symbol;

import java.util.HashSet;
import java.util.Set;


public class TestUtil {

    public static Day03Puzzle02Solver solver = new Day03Puzzle02Solver();


    public static Set<SchematicToken> createEmptySchematicTokenSet() {
        return new HashSet<>();
    }

    public static String lineContainingSymbols() {
        return "*......+.....;";
    }


    public static Set<SchematicToken> createSetForLineContainingSymbols() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(new GearSymbol(0));
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
        tokens.add(new GearSymbol(13));
        tokens.add(createSingleDigitNumberWithAdjacentTokenToTheLeft());
        tokens.add(createSingleDigitNumberWithAdjacentTokenToTheRight());
        tokens.add(new Symbol(19));
        tokens.add(createSingleDigitNumberWithNoAdjacentTokens());
        tokens.add(new GearSymbol(25));
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

    public static Set<SchematicToken> createSetWithSomeGearSymbols() {
        var tokens = solver.convertLineToSchematicTokens(".7*..*2..%3..5*11......13*17.......");
        solver.processTokens(tokens);
        return tokens;
    }


    public static String lineContainingGears() {
        return "..2*7..2/..3*..%4.*6.";
    }

    public static Set<SchematicToken> createSetForLineContainingGears() {
        Set<SchematicToken> tokens = new HashSet<>();
        tokens.add(new Number(2, 2));
        tokens.add(new GearSymbol(3));
        tokens.add(new Number(4, 7));
        tokens.add(new Number(7, 2));
        tokens.add(new Symbol(8));
        tokens.add(new Number(11, 3));
        tokens.add(new GearSymbol(12));
        tokens.add(new Symbol(15));
        tokens.add(new Number(16, 4));
        tokens.add(new GearSymbol(18));
        tokens.add(new Number(19, 6));
        solver.processTokens(tokens);
        return tokens;
    }
}
