package org.amaap.troopsimulationgame.controller;

import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.InMemoryTroopRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.repository.impl.db.impl.FakeDatabase;
import org.amaap.troopsimulationgame.service.TroopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TroopControllerTest {
    private TroopController troopController;
    private TroopService troopService;
    private TroopRepository repository;
    private InMemoryDatabase database;

    @BeforeEach
    void setUp() {
        database = new FakeDatabase();
        repository = new InMemoryTroopRepository(database);
        troopService = new TroopService(repository);
        troopController = new TroopController(troopService);
    }


    @Test
    void shouldBeAbleToReturnOkIfTroopAreCreated() {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        Response expected = new Response(HttpStatus.OK, "Troop Created Successfully");

        // act
        Response actual = troopController.create(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfTroopCountIsInvalid() {
        // arrange
        int troopCount = -1;
        String troopType = "Barbarian";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + troopCount);

        // act
        Response actual = troopController.create(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfTroopTypeIsInvalid() {
        // arrange
        int troopCount = 10;
        String troopType = "9809";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " +troopType);

        // act
        Response actual = troopController.create(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

}