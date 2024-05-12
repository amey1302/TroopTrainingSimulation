package org.amaap.troopsimulationgame.repository.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.controller.TroopController;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.ArmyCampRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.repository.impl.db.impl.FakeDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryArmyCampRepositoryTest {
    private ArmyCampRepository armyCampRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        armyCampRepository = injector.getInstance(ArmyCampRepository.class);
    }

    @Test
    void shouldSaveTrainedTroopersIntoArmyCamp() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(3, 20, "Bow");
        Trooper barbarian = new Barbarian(6, 30, "Sword");
        List<Trooper> trainedTroops = new ArrayList<>();
        trainedTroops.add(archer);
        trainedTroops.add(barbarian);

        // act
        armyCampRepository.save(trainedTroops);
        List<Trooper> savedTroops = armyCampRepository.getTrainedTroops();

        // assert
        assertEquals(trainedTroops.size(), savedTroops.size(), "All trained troopers should be saved");
        assertEquals(archer, savedTroops.get(0), "First saved trooper should match the Archer");
        assertEquals(barbarian, savedTroops.get(1), "Second saved trooper should match the Barbarian");
    }

    @Test
    void shouldRetrieveTrainedTroopsFromArmyCamp() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(3, 20, "Bow");
        Trooper barbarian = new Barbarian(6, 30, "Sword");
        List<Trooper> trainedTroops = new ArrayList<>();
        trainedTroops.add(archer);
        trainedTroops.add(barbarian);
        armyCampRepository.save(trainedTroops);

        // act
        List<Trooper> retrievedTroops = armyCampRepository.getTrainedTroops();

        // assert
        assertEquals(trainedTroops.size(), retrievedTroops.size(), "All trained troopers should be retrieved");
        assertEquals(archer, retrievedTroops.get(0), "First retrieved trooper should match the Archer");
        assertEquals(barbarian, retrievedTroops.get(1), "Second retrieved trooper should match the Barbarian");
    }

    @Test
    void shouldSetAndGetTrainedArcherCount() {
        // arrange
        int count = 5;

        // act
        armyCampRepository.setTrainedArcherCount(count);
        int retrievedCount = armyCampRepository.getTrainedArcherCount();

        // assert
        assertEquals(count, retrievedCount, "Trained Archer count should match");
    }

    @Test
    void shouldSetAndGetTrainedBarbarianCount() {
        // arrange
        int count = 8;

        // act
        armyCampRepository.setTrainedBarbarianCount(count);
        int retrievedCount = armyCampRepository.getTrainedBarbarianCount();

        // assert
        assertEquals(count, retrievedCount, "Trained Barbarian count should match");
    }
}
