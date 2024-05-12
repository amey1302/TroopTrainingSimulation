package org.amaap.troopsimulationgame.repository.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryBarrackRepositoryTest {
    private BarrackRepository barrackRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        barrackRepository = injector.getInstance(BarrackRepository.class);
    }

    @Test
    void shouldBeAbleToInsertTrooperIntoBarrack() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Archer(3, 20, "Bow");

        // act
        barrackRepository.insert(trooper);
        List<Trooper> troopers = barrackRepository.getTroopers();

        // assert
        assertEquals(1, troopers.size(), "Trooper should be inserted into the barrack");
        assertEquals(trooper, troopers.get(0), "Inserted trooper should match retrieved trooper");
    }

    @Test
    void shouldBeAbleToRetrieveTrainedTroopersFromBarrack() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(3, 20, "Bow");
        Trooper barbarian = new Barbarian(6, 30, "Sword");
        List<Trooper> troops = new ArrayList<>();
        troops.add(archer);
        troops.add(barbarian);
        barrackRepository.save(troops);

        // act
        List<Trooper> trainedTroopers = barrackRepository.getTrainedTroops();

        // assert
        assertEquals(2, trainedTroopers.size(), "Should retrieve all trained troopers from the barrack");
        assertEquals(archer, trainedTroopers.get(0), "First trained trooper should match the Archer");
        assertEquals(barbarian, trainedTroopers.get(1), "Second trained trooper should match the Barbarian");
    }
}
