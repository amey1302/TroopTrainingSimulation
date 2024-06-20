package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarbarianTest {

    @Test
    void shouldCreateValidBarbarian() throws InvalidTroopDataException {
        // arrange & act
        Trooper barbarian = new Barbarian(3, 10, "sword");

        // assert
        assertNotNull(barbarian);
        assertEquals(3, barbarian.getTrainingTime());
        assertEquals(10, barbarian.getTrainingCost());
    }

    @Test
    void shouldThrowExceptionForInvalidBarbarianParameters() {
        // assert
        assertThrows(InvalidTroopTrainingCostException.class, () -> new Barbarian(-1, 10, "sword"));
        assertThrows(InvalidTroopTrainingCostException.class, () -> new Barbarian(3, -10, "sword"));
    }

    @Test
    void shouldReturnCorrectStringForBarbarian() throws InvalidTroopDataException {
        // arrange
        Trooper barbarian = new Barbarian(3, 10, "sword");

        // act
        String barbarianString = barbarian.toString();

        // assert
        assertEquals("Barbarian{trainingTime=3, trainingCost=10'}", barbarianString);
    }
}
