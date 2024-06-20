package org.amaap.troopsimulationgame.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TroopServiceTest {
    private TroopService troopService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        troopService = injector.getInstance(TroopService.class);
    }

    @Test
    void shouldThrowInvalidTroopTrainingCostExceptionWhenTrainingCostIsZero() {
        // arrange
        int trainingCost = 0;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingCostException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingCostExceptionWhenTrainingCostIsNegative() {
        // arrange
        int trainingCost = -1;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingCostException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingTimeExceptionWhenTrainingTimeIsZero() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 0;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingTimeExceptionWhenTrainingTimeIsNegative() {
        // arrange
        int trainingCost = 100;
        int trainingTime = -10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTypeExceptionWhenTypeIsNull() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = null;

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTypeExceptionWhenTypeIsNotValid() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = "Knight";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldBeAbleToCreateArcher() {
        // arrange
        int trainingCost = 20;
        int trainingTime = 6;
        String troopType = "Archer";
        String weapon = "bow and arrow";

        // act and assert
        assertDoesNotThrow(() -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldBeAbleToInsertRecordInTroopRepository() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertDoesNotThrow(() -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

    @Test
    void shouldBeAbleToCreateBarbarian() {
        // arrange
        int trainingCost = 10;
        int trainingTime = 3;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertDoesNotThrow(() -> troopService.create(troopType, trainingTime, trainingCost, weapon));
    }

}
