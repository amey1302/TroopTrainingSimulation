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
    private InMemoryDatabase inMemoryDatabase;

    @BeforeEach
    void setUp() {
        inMemoryDatabase = new FakeDatabase();
        repository = new InMemoryTroopRepository(inMemoryDatabase);
        troopService = new TroopService(repository);
        troopController = new TroopController(troopService);
    }


    @Test
    void shouldBeAbleToReturnOkIfTBarbarianIsCreated() {
        // arrange
        String troopType = "Barbarian";
        int trainingTime = 3;
        int trainingCost = 10;
        String weapon = "sword";
        Response expected = new Response(HttpStatus.OK, "Troop Created Successfully");

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnOkIfArcherIsCreated() {
        // arrange
        String troopType = "Archer";
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "bow and arrow";
        Response expected = new Response(HttpStatus.OK, "Troop Created Successfully");

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfTrainingTimeIsInvalid() {
        // arrange
        String troopType = "Archer";
        int trainingTime = -1;
        int trainingCost = 20;
        String weapon = "bow and arrow";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + trainingTime);

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfTrainingCostIsInvalid() {
        // arrange
        String troopType = "Archer";
        int trainingTime = 6;
        int trainingCost = -20;
        String weapon = "bow and arrow";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + trainingCost);

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfTroopTypeIsInvalid() {
        // arrange
        int trainingTime = 6;
        int trainingCost = 20;
        String weapon = "bow and arrow";
        String troopType = "9809";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + troopType);

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnBAD_REQUESTIfWeaponIsInvalid() {
        // arrange
        String troopType = "Archer";
        int trainingTime = 1;
        int trainingCost = 20;
        String weapon = "8877";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Invalid Input Parameter " + weapon);

        // act
        Response actual = troopController.create(troopType, trainingTime, trainingCost, weapon);

        // assert
        assertEquals(expected, actual);
    }

}