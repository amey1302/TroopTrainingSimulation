package org.amaap.troopsimulationgame.repository;

import org.amaap.troopsimulationgame.domain.model.entity.Trooper;

import java.util.List;

public interface ArmyCampRepository {
    public void save(List<Trooper> trooperList);

    List<Trooper> getTrainedTroops();
    int getTrainedArcherCount();

    void setTrainedArcherCount(int count);

    int getTrainedBarbarianCount();

    void setTrainedBarbarianCount(int count);
}
