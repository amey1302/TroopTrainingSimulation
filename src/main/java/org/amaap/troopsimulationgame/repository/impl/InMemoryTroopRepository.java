package org.amaap.troopsimulationgame.repository.impl;

import jakarta.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
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
    public void insert(Trooper trooper) throws InvalidTroopTypeException {
        inMemoryDatabase.insertIntoTroopTable(trooper);
    }

    @Override
    public List<Trooper> getTroopers() {
        return inMemoryDatabase.getTroops();
    }
}