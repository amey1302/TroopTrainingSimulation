package org.amaap.troopsimulationgame.repository;

import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface BarrackRepository {
    public void insert(Trooper trooper) throws InvalidTroopTypeException;

    List<Trooper> getTroopers();

    void save(List<Trooper> troops);

    List<Trooper> getTrainedTroops();


}
