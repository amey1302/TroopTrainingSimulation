package org.amaap.troopsimulationgame.service;

import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryTroopRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TroopServiceTest {
    private TroopService troopService;
    private TroopRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTroopRepository();
        troopService = new TroopService(repository);
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingCostIsZero() {
        // arrange
        int trainingCost = 0;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingCostIsNegative() {
        // arrange
        int trainingCost = -1;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingTimeIsZero() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 0;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingTimeIsNegative() {
        // arrange
        int trainingCost = 100;
        int trainingTime = -10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeIsNull() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = null;

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeIsNotValid() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = "Knight";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToThrowInvalidWeaponExceptionWhenWeaponIsNull() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = null;

        // act and assert
        assertThrows(InvalidWeaponException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToCreateTroopWhenInputIsValid() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertDoesNotThrow(() -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldBeAbleToInsertRecordInTroopRepository() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertDoesNotThrow(() -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

}
