package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrooperTest {
    @Test
    void shouldBeAbleToGetTrainingTimeOfBarbarian() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Barbarian(3, 10, "sword");

        // act
        int actualTrainingTime = 3;

        // assert
        assertEquals(trooper.getTrainingTime(), actualTrainingTime);
    }

    @Test
    void shouldBeAbleToGetTrainingTimeOfArcher() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Archer(6, 20, "bow and arrow");

        // act
        int actualTrainingTime = 6;

        // assert
        assertEquals(trooper.getTrainingTime(), actualTrainingTime);
    }

    @Test
    void shouldBeAbleToGetTrainingCostOfBarbarian() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Barbarian(3, 10, "sword");

        // act
        int actualTrainingCost = 10;

        // assert
        assertEquals(trooper.getTrainingCost(), actualTrainingCost);
    }

    @Test
    void shouldBeAbleToGetTrainingCostOfArcher() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Archer(6, 20, "bow and arrow");

        // act
        int actualTrainingCost = 20;

        // assert
        assertEquals(trooper.getTrainingCost(), actualTrainingCost);
    }

    @Test
    void shouldBeAbleToGetInstanceOfBarbarian() throws InvalidTroopDataException {
        // arrange
        Trooper expectedTrooper = new Barbarian(3, 10, "sword");

        // assert
        assertTrue(expectedTrooper instanceof Barbarian);
    }

    @Test
    void shouldBeAbleToGetInstanceOfArcher() throws InvalidTroopDataException {
        // arrange
        Trooper expectedTrooper = new Archer(6, 20, "bow and arrow");

        // assert
        assertTrue(expectedTrooper instanceof Archer);
    }

    @Test
    void shouldBeEqualWhenTrooperAttributesAreSame() throws InvalidTroopDataException {
        // arrange
        Trooper trooper1 = new Barbarian(3, 10, "sword");
        Trooper trooper2 = new Barbarian(3, 10, "sword");

        // assert
        assertEquals(trooper1, trooper2);
    }

    @Test
    void shouldNotBeEqualWhenTrooperAttributesAreDifferent() throws InvalidTroopDataException {
        // arrange
        Trooper trooper1 = new Barbarian(3, 10, "sword");
        Trooper trooper2 = new Barbarian(4, 10, "sword");

        // assert
        assertNotEquals(trooper1, trooper2);
    }

    @Test
    void shouldNotBeEqualWhenTrooperTypesAreDifferent() throws InvalidTroopDataException {
        // arrange
        Trooper trooper1 = new Barbarian(3, 10, "sword");
        Trooper trooper2 = new Archer(3, 10, "sword");

        // assert
        assertNotEquals(trooper1, trooper2);
    }
}
