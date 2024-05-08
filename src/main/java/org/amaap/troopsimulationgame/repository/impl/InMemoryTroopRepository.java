package org.amaap.troopsimulationgame.repository.impl;

import jakarta.inject.Inject;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public class InMemoryTroopRepository implements TroopRepository {
    private InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryTroopRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void insert(int troopCount, String troopType) throws InvalidTroopTypeException {
        inMemoryDatabase.insertIntoTroopTable(troopCount,troopType);
    }


    @Override
    public List<Object> getBarbarians() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public List<Object> getArchers() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public List<Object> getTroopers() {
        return inMemoryDatabase.getTroopers();
    }
}
