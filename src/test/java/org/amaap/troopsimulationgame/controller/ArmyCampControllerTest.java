package org.amaap.troopsimulationgame.controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.controller.dto.HttpStatus;
import org.amaap.troopsimulationgame.controller.dto.Response;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArmyCampControllerTest {
    private ArmyCampController armyCampController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        armyCampController = injector.getInstance(ArmyCampController.class);
    }

    @Test
    void shouldBeAbleReturnOkResponseIfTroopsAreAvailableInArmyCamp() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(6, 20, "bow and arrow");
        Trooper barbarian = new Barbarian(3, 10, "sword");
        List<Trooper> trainedTroops = new ArrayList<>();
        trainedTroops.add(archer);
        trainedTroops.add(barbarian);
        Response expected = new Response(HttpStatus.OK, "Troops are available in ArmyCamp");

        // act
        Response actual = armyCampController.addTrainedTrooperIntoArmyCamp(trainedTroops);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleReturnBadRequestResponseIfTroopsAreNotAvailableInArmyCamp() {
        // arrange
        List<Trooper> trainedTroops = Collections.emptyList();
        Response expected = new Response(HttpStatus.BAD_REQUEST, "Troops are not available");

        // act
        Response actual = armyCampController.addTrainedTrooperIntoArmyCamp(trainedTroops);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleReturnOKResponseIfTroopsWithTypeIsSameAsExpected() throws InvalidTroopDataException, NoTrainedTroopsAvailableException {
        // arrange
        Trooper archer = new Archer(6, 20, "bow and arrow");
        Trooper barbarian = new Barbarian(3, 10, "sword");
        List<Trooper> trainedTroops = new ArrayList<>();
        trainedTroops.add(archer);
        trainedTroops.add(barbarian);
        String troopType = "Barbarian";
        Response expected = new Response(HttpStatus.OK, "Troops Available in ArmyCamp");

        // act
        Response actual = armyCampController.getTroopersCountFor(troopType);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleReturnBadRequestResponseIfNoTroopsInArmyCampForTroopType() {
        // arrange
        String troopType = "knight";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "No Troops in ArmyCamp For this TroopType");

        // act
        Response actual = armyCampController.getTroopersCountFor(troopType);

        // assert
        assertEquals(expected, actual);
    }
}
