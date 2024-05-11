package org.amaap.troopsimulationgame.repository.impl.db.impl;

import org.amaap.troopsimulationgame.domain.model.Trooper;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {
    private List<Trooper> troopList = new ArrayList<>();
    private List<Object> trainedTroopers = new ArrayList<>();
    private int archerCount = 0;
    private int barbarianCount = 0;


    @Override
    public void insertIntoTroopTable(Trooper trooper) throws InvalidTroopTypeException {
       troopList.add(trooper);
    }

    @Override
    public List<Trooper> getTroopers()
    {
        return troopList;
    }

}
