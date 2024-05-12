package org.amaap.troopsimulationgame.controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BarrackControllerTest {
    private BarrackController barrackController;
    @BeforeEach
    void setup() {
        Injector injector = Guice.createInjector(new TroopModule());
        barrackController = injector.getInstance(BarrackController.class);
    }

    @Test
    void shouldBeAbleToReturnOkResponseIfDataIsValid() {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        Response expected = new Response(HttpStatus.OK, "Troops Created Successfully");

        // act
        Response actual = barrackController.create(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBad_RequestResponseIfDataIsInvalid() {
        // arrange
        int troopCount = 10;
        String troopType = "knight";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter");

        // act
        Response actual = barrackController.create(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnOkResponseIfTrainingIsComplete() throws InvalidWeaponException, InvalidTroopTrainingTimeAndCostException {
        // arrange
        List<Trooper> troopers = new ArrayList<>();
        troopers.add(new Trooper(3, 10, "sword"));
        Response expected = new Response(HttpStatus.OK, "Troops Trained Successfully");

        // act
        Response actual = barrackController.trainTroopers();

        // assert
        assertEquals(expected, actual);
    }


}