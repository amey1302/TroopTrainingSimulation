package org.amaap.troopsimulationgame.repository.impl;

import com.google.inject.Inject;
import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.ArmyCampRepository;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;

import java.util.List;

public class InMemoryArmyCampRepository implements ArmyCampRepository {
    private InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryArmyCampRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void save(List<Trooper> trooperList) {
        inMemoryDatabase.insertIntoArmyCampTable(trooperList);
    }

    @Override
    public List<Trooper> getTrainedTroops() {
        return inMemoryDatabase.getTrainedTroopsFromArmyCamp();
    }

    @Override
    public int getTrainedArcherCount() {
        return inMemoryDatabase.getTrainedArcherCount();
    }

    @Override
    public void setTrainedArcherCount(int count) {
        inMemoryDatabase.setTrainedArcherCount(count);
    }

    @Override
    public int getTrainedBarbarianCount() {
        return inMemoryDatabase.getTrainedBarbarianCount();
    }

    @Override
    public void setTrainedBarbarianCount(int count) {
        inMemoryDatabase.setTrainedBarbarianCount(count);
    }

}
