package org.amaap.troopsimulationgame.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.ArmyCampRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.amaap.troopsimulationgame.service.builder.TrainedTroop.trainedTroopers;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyCampServiceTest {
    private ArmyCampService armyCampService;
    private ArmyCampRepository armyCampRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        armyCampService = injector.getInstance(ArmyCampService.class);
        armyCampRepository = injector.getInstance(ArmyCampRepository.class);
    }

    @Test
    void shouldBeAbleToStoreTrainedTroopsFromBarrackToArmyCamp() throws InvalidTroopDataException, NoTrainedTroopsAvailableException {
        // arrange
        Trooper archer = new Archer(6, 20, "bow and arrow");
        Trooper barbarian = new Barbarian(3, 10, "sword");
        List<Trooper> expectedTrainedTroops = new ArrayList<>();
        expectedTrainedTroops.add(archer);
        expectedTrainedTroops.add(barbarian);

        // act
        armyCampService.addTrainedTrooperFromBarrackToArmyCamp(expectedTrainedTroops);
        List<Trooper> actualTrainedTroopsFromCamp = armyCampService.getTrainedTroops();

        // assert
        assertEquals(expectedTrainedTroops, actualTrainedTroopsFromCamp);

    }

    @Test
    void shouldBeAbleToGetTroopersCountForArcherAndBarbarian() throws InvalidTroopDataException, NoTrainedTroopsAvailableException {
        // arrange
        armyCampRepository.save(trainedTroopers());
        armyCampService.calculateTroopCount("Barbarian");
        armyCampService.calculateTroopCount("Archer");

        // act
        armyCampService.addTrainedTrooperFromBarrackToArmyCamp(trainedTroopers());
        int archerCount = armyCampService.getTroopersCountFor("Archer");
        int barbarianCount = armyCampService.getTroopersCountFor("Barbarian");

        // assert
        assertEquals(2, archerCount);
        assertEquals(2, barbarianCount);
    }


}