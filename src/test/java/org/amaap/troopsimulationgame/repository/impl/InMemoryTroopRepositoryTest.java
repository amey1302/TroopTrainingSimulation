package org.amaap.troopsimulationgame.repository.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.troopsimulationgame.TroopModule;
import org.amaap.troopsimulationgame.domain.model.entity.Archer;
import org.amaap.troopsimulationgame.domain.model.entity.Barbarian;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryTroopRepositoryTest {
    private InMemoryTroopRepository inMemoryTroopRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new TroopModule());
        inMemoryTroopRepository = injector.getInstance(InMemoryTroopRepository.class);
    }


    @Test
    void shouldBeAbleToInsertArcherIntoRepository() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Archer(6, 20, "bow and arrow");

        // act
        inMemoryTroopRepository.insert(trooper);

        // assert
        List<Trooper> troops = inMemoryTroopRepository.getTroopers();
        assertEquals(1, troops.size());
        assertEquals(trooper, troops.get(0));
    }

    @Test
    void shouldBeAbleToInsertBarbarianIntoRepository() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Barbarian(3, 10, "sword");

        // act
        inMemoryTroopRepository.insert(trooper);

        // assert
        List<Trooper> troops = inMemoryTroopRepository.getTroopers();
        assertEquals(1, troops.size());
        assertEquals(trooper, troops.get(0));
    }

    @Test
    void shouldBeAbleToGetTroopers() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(6, 20, "bow and arrow");
        Trooper barbarian = new Barbarian(3, 10, "sword");
        inMemoryTroopRepository.insert(archer);
        inMemoryTroopRepository.insert(barbarian);

        // act
        List<Trooper> troops = inMemoryTroopRepository.getTroopers();

        // assert
        assertEquals(2, troops.size());
        assertEquals(archer, troops.get(0));
        assertEquals(barbarian, troops.get(1));
    }
}
