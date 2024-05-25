package org.amaap.troopsimulationgame.repository.impl.db;

import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface InMemoryDatabase {
    void insertIntoTroopTable(Trooper trooper) throws InvalidTroopTypeException;

    List<Trooper> getTroops();

    void insertIntoBarrackTable(Trooper trooper) throws InvalidTroopTypeException;

    List<Trooper> getTroopers();
    void save(List<Trooper> troops);

    List<Trooper> getTrainedTroops();

    void insertIntoArmyCampTable(List<Trooper> trooperList);

    List<Trooper> getTrainedTroopsFromArmyCamp();


    int getTrainedArcherCount();

    void setTrainedArcherCount(int count);

    int getTrainedBarbarianCount();

    void setTrainedBarbarianCount(int count);
}
