package org.amaap.troopsimulationgame.controller;

import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopControllerTest {
    TroopController troopController = new TroopController();
    @Test
    void shouldBeAbleToReturnOkIfTroopAreCreated(){
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        Response expected = new Response(HttpStatus.OK,"Troop Created Successfully");

        // act
        Response actual = troopController.create(troopCount,troopType);

        // assert
        assertEquals(expected,actual);
    }

}