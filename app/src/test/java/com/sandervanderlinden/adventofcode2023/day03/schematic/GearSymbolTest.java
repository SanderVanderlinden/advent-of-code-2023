package com.sandervanderlinden.adventofcode2023.day03.schematic;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.sandervanderlinden.adventofcode2023.day03.util.TestUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GearSymbolTest {

    @Test
    void getRatio() {
        Set<SchematicToken> tokens = solver.convertLineToSchematicTokens(lineContainingGears());
        solver.processTokens(tokens);

        GearSymbol gearSymbol = tokens.stream()
                .filter(token -> token instanceof GearSymbol && token.getPositionIndex() == 3)
                .map(token -> (GearSymbol) token)
                .findFirst()
                .orElseThrow(() -> new AssertionError("GearSymbol not found at index 3"));

        int expectedRatio = 14; // The expected gear ratio at this index

        assertEquals(expectedRatio, gearSymbol.getRatio(), "Gear ratio did not match the expected value.");
    }
}