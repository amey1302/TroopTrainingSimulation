package org.amaap.troopsimulationgame.service;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopCountException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopServiceTest {
    private TroopService troopService;

    @BeforeEach
    void setUp() {
        troopService = new TroopService();
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopCountExceptionWhenCountIsZero() {
        // arrange
        int troopCount = 0;
        String troopType = "Barbarian";

        // act and assert
        assertThrows(InvalidTroopCountException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopCountExceptionWhenCountIsNegative() {
        // arrange
        int troopCount = -1;
        String troopType = "Barbarian";

        // act and assert
        assertThrows(InvalidTroopCountException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeIsNull() {
        // arrange
        int troopCount = 10;
        String troopType = null;

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeIsEmpty() {
        // arrange
        int troopCount = 10;
        String troopType = "";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeContainsSpaces() {
        // arrange
        int troopCount = 10;
        String troopType = "Bar barian";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeIsNotValid() {
        // arrange
        int troopCount = 10;
        String troopType = "Knight";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToThrowInvalidTroopTypeExceptionWhenTypeContainsDigits() {
        // arrange
        int troopCount = 10;
        String troopType = "123Archer";

        // act and assert
        assertThrows(InvalidTroopTypeException.class, () -> troopService.create(troopCount, troopType));
    }

    @Test
    void shouldBeAbleToCreateTroopWhenCountAndTypeAreValid(){
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        // act and assert
        assertDoesNotThrow(() -> {
            troopService.create(troopCount, troopType);
            return true;
        });
    }
}
