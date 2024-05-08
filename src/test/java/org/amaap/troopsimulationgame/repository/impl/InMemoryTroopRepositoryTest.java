package org.amaap.troopsimulationgame.repository.impl;

import org.amaap.troopsimulationgame.domain.model.Archer;
import org.amaap.troopsimulationgame.domain.model.Barbarian;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.repository.impl.db.impl.FakeDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryTroopRepositoryTest {
    private InMemoryDatabase database;
    private InMemoryTroopRepository repository;

    @BeforeEach
    void setUp() {
        database = new FakeDatabase();
        repository = new InMemoryTroopRepository(database);
    }

    @Test
    void shouldBeAbleToInsertBarbariansIntoDatabase() throws InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        // act
        repository.insert(troopCount, troopType);
        int actualBarbarianCount = repository.getBarbarians().size();

        // assert
        assertEquals(troopCount, actualBarbarianCount);
    }

    @Test
    void shouldBeAbleToInsertArchersIntoDatabase() throws InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Archer";

        // act
        repository.insert(troopCount, troopType);
        int actualArcherCount = repository.getArchers().size();

        // assert
        assertEquals(troopCount, actualArcherCount);
    }

    @Test
    void shouldThrowExceptionForInvalidTroopType() {
        // arrange
        int troopCount = 10;
        String invalidTroopType = "InvalidTroopType";

        // act & assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            repository.insert(troopCount, invalidTroopType);
        });
    }

    @Test
    void shouldBeAbleToGetTroopers() throws InvalidTroopTypeException {
        // arrange
        int barbarianCount = 5;
        int archerCount = 5;
        String barbarianType = "Barbarian";
        String archerType = "Archer";

        // act
        database.insertIntoTroopTable(barbarianCount, barbarianType);
        database.insertIntoTroopTable(archerCount, archerType);
        List<Object> troopers = repository.getTroopers();


        // assert
        assertEquals(10, troopers.size());
        int barbarianCountInTroopers = 0;
        int archerCountInTroopers = 0;
        for (Object trooper : troopers) {
            if (trooper instanceof Barbarian) {
                barbarianCountInTroopers++;
            } else if (trooper instanceof Archer) {
                archerCountInTroopers++;
            }
        }
        assertEquals(barbarianCount, barbarianCountInTroopers);
        assertEquals(archerCount, archerCountInTroopers);
    }

}