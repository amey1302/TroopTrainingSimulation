package org.amaap.troopsimulationgame.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryTroopRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.repository.impl.db.impl.FakeDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;
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
    void shouldThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingCostIsZero() {
        // arrange
        int trainingCost = 0;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingCostIsNegative() {
        // arrange
        int trainingCost = -1;
        int trainingTime = 10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingTimeIsZero() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 0;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTrainingTimeAndCostExceptionWhenTrainingTimeIsNegative() {
        // arrange
        int trainingCost = 100;
        int trainingTime = -10;
        String troopType = "Barbarian";
        String weapon = "Sword";

        // act and assert
        assertThrows(InvalidTroopTrainingTimeAndCostException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTypeExceptionWhenTypeIsNull() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = null;

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidTroopTypeExceptionWhenTypeIsNotValid() {
        // arrange
        int trainingCost = 100;
        int trainingTime = 10;
        String weapon = "Sword";
        String troopType = "Knight";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopType, trainingCost, trainingTime, weapon));
    }

    @Test
    void shouldThrowInvalidWeaponExceptionWhenWeaponIsNull() {
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
