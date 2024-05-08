package org.amaap.troopsimulationgame.repository;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface TroopRepository {
    void insert(int troopCount, String troopType) throws InvalidTroopTypeException;

    List<Object> getBarbarians();

    List<Object> getArchers();

    List<Object> getTroopers();
}
