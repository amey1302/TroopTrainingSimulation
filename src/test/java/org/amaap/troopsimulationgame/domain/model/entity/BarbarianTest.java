package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeException;
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
    void shouldReturnCorrectStringForBarbarian() throws InvalidTroopDataException {
        // arrange
        Trooper barbarian = new Barbarian(3, 10, "sword");

        // act
        String barbarianString = barbarian.toString();

        // assert
        assertEquals("Barbarian{trainingTime=3, trainingCost=10'}", barbarianString);
    }
}
