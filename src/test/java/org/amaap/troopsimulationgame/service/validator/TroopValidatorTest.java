package org.amaap.troopsimulationgame.service.validator;

import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopValidatorTest {

    @Test
    void shouldBeAbleToReturnTrueForInvalidCases() {
        assertTrue(TroopValidator.isInvalid(null));
        assertTrue(TroopValidator.isInvalid(""));
        assertTrue(TroopValidator.isInvalid("archer with spaces"));
        assertTrue(TroopValidator.isInvalid("1234"));
        assertTrue(TroopValidator.isInvalid("archer123"));
    }

    @Test
    void shouldBeAbleToGetTrooperClass() throws InvalidTroopTypeException {
        assertEquals(Archer.class, TroopValidator.getTroopClass("archer"));
        assertEquals(Barbarian.class, TroopValidator.getTroopClass("barbarian"));

        Exception exception = assertThrows(InvalidTroopTypeException.class, () -> {
            TroopValidator.getTroopClass("invalid");
        });
        String expectedMessage = "Invalid troop type: invalid";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
