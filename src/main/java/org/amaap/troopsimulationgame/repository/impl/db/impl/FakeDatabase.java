package org.amaap.troopsimulationgame.repository.impl.db.impl;

import org.amaap.troopsimulationgame.domain.model.Archer;
import org.amaap.troopsimulationgame.domain.model.Barbarian;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {
    private List<Object> troops = new ArrayList<>();
    private List<Object> troopers = new ArrayList<>();
    private List<Object> trainedTroopers = new ArrayList<>();


    @Override
    public void insertIntoTroopTable(String troopType, int trainingCost, int trainingTime, String weapon) throws InvalidTroopTypeException {
        if ("Barbarian".equals(troopType)) {
            troops.add(new Barbarian(trainingTime, trainingCost, weapon));
        } else if ("Archer".equals(troopType)) {
            troops.add(new Archer(trainingTime, trainingCost, weapon));
        } else {
            throw new InvalidTroopTypeException("Invalid Troop Parameter " + troopType);
        }
    }

    @Override
    public List<Object> getTroops() {
        return troops;
    }

    @Override
    public void insertIntoBarrackTable(String troopType) {
        troopers.add(troopType);
    }

    @Override
    public List<Object> getTroopersFromBarrackRepo() {
        return troopers;
    }

    @Override
    public void save(List<Object> trainedTroops) {
        trainedTroopers.add(trainedTroops);
    }
}
