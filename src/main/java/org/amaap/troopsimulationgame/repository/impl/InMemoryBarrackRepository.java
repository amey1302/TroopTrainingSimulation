package org.amaap.troopsimulationgame.repository.impl;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.BarrackRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public class InMemoryBarrackRepository implements BarrackRepository {
    private InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryBarrackRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void insert(Trooper trooper) throws InvalidTroopTypeException {
        inMemoryDatabase.insertIntoBarrackTable(trooper);
    }

    @Override
    public List<Trooper> getTroopers() {
        return inMemoryDatabase.getTroopers();
    }

    @Override
    public void save(List<Trooper> troops) {
        inMemoryDatabase.save(troops);
    }

    @Override
    public List<Trooper> getTrainedTroops() {
        return inMemoryDatabase.getTrainedTroops();
    }


}
