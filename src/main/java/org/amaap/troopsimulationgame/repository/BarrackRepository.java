package org.amaap.troopsimulationgame.repository;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface BarrackRepository {
    public void insert(String troopType) throws InvalidTroopTypeException;\
    List<Object> getTroopers();
    void trainedTroops(List<Object> troops);
    List<Object> getTrainedTroops();

    int getTrainedArcherCount();

    void setTrainedArcherCount(int count);

    int getTrainedBarbarianCount();

    void setTrainedBarbarianCount(int count);
}
