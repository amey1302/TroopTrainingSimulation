package org.amaap.troopsimulationgame.repository.impl.db;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface InMemoryDatabase {
    void insertIntoTroopTable(int troopCount, String troopType) throws InvalidTroopTypeException;
    List<Object> getTroopers();
}
