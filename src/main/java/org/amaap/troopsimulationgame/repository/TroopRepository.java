package org.amaap.troopsimulationgame.repository;

import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface TroopRepository {
    void insert(Trooper trooper) throws InvalidTroopTypeException;

    List<Trooper> getTroopers();
}