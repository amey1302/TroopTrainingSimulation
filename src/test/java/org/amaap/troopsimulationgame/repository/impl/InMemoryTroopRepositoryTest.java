package org.amaap.troopsimulationgame.repository.impl;

import org.amaap.troopsimulationgame.domain.model.Archer;
import org.amaap.troopsimulationgame.domain.model.Barbarian;
import org.amaap.troopsimulationgame.domain.model.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryTroopRepositoryTest {
    private InMemoryTroopRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryTroopRepository();
    }


    @Test
    void shouldBeAbleToInsertArcherIntoRepository() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Archer(6, 20, "bow and arrow");

        // act
        repository.insert(trooper);

        // assert
        List<Trooper> troopers = repository.getTroopers();
        assertEquals(1, troopers.size());
        assertEquals(trooper, troopers.get(0));
    }

    @Test
    void shouldBeAbleToInsertBarbarianIntoRepository() throws InvalidTroopDataException {
        // arrange
        Trooper trooper = new Barbarian(3, 10, "sword");

        // act
        repository.insert(trooper);

        // assert
        List<Trooper> troopers = repository.getTroopers();
        assertEquals(1, troopers.size());
        assertEquals(trooper, troopers.get(0));
    }

    @Test
    void shouldBeAbleToGetTroopers() throws InvalidTroopDataException {
        // arrange
        Trooper archer = new Archer(6, 20, "bow and arrow");
        Trooper barbarian = new Barbarian(3, 10, "sword");
        repository.insert(archer);
        repository.insert(barbarian);

        // act
        List<Trooper> troopers = repository.getTroopers();

        // assert
        assertEquals(2, troopers.size());
        assertEquals(archer, troopers.get(0));
        assertEquals(barbarian, troopers.get(1));
    }
}
