package org.amaap.troopsimulationgame.repository.impl.db;

import org.amaap.troopsimulationgame.domain.model.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface InMemoryDatabase {
    void insertIntoTroopTable(Trooper trooper) throws InvalidTroopTypeException;

    List<Trooper> getTroopers();




}
