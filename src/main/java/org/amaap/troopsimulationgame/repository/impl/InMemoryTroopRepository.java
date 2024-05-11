package org.amaap.troopsimulationgame.repository.impl;

import jakarta.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.Trooper;
import org.amaap.troopsimulationgame.repository.TroopRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTroopRepository implements TroopRepository {

    List<Trooper> troopers = new ArrayList<>();

    @Override
    public void insert(Trooper trooper) throws InvalidTroopTypeException {
       troopers.add(trooper);
    }

    @Override
    public List<Trooper> getTroopers() {
        return troopers;
    }
}