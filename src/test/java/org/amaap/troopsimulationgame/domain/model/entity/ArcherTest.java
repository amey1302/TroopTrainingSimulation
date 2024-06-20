package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void shouldCreateValidArcher() throws InvalidTroopDataException {
        // arrange & act
        Trooper archer = new Archer(5, 15, "bow and arrow");

        // assert
        assertNotNull(archer);
        assertEquals(5, archer.getTrainingTime());
        assertEquals(15, archer.getTrainingCost());
    }

    @Test
    void shouldThrowExceptionForInvalidArcherParameters() {
        // assert
        assertThrows(InvalidTroopTrainingCostException.class, () -> new Archer(-1, 15, "bow and arrow"));
        assertThrows(InvalidTroopTrainingCostException.class, () -> new Archer(5, -15, "bow and arrow"));
    }

    @Test
    void shouldReturnCorrectStringForArcher() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(5, 15, "bow and arrow");

        // act
        String archerString = archer.toString();

        // assert
        assertEquals("Archer{trainingTime=5, trainingCost=15'}", archerString);
    }
}
