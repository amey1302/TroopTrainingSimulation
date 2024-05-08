package org.amaap.troopsimulationgame.repository.impl.db.impl;

import org.amaap.troopsimulationgame.domain.model.Archer;
import org.amaap.troopsimulationgame.domain.model.Barbarian;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {
    private List<Object> troopList = new ArrayList<>();


    @Override
    public void insertIntoTroopTable(int troopCount, String troopType) throws InvalidTroopTypeException {
        if ("Barbarian".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Barbarian());
            }
        } else if ("Archer".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Archer());
            }
        } else {
            throw new InvalidTroopTypeException("Invalid Troop Parameter " + troopType);
        }
    }
    @Override
    public List<Object> getTroopers() {
        return troopList;
    }
}
