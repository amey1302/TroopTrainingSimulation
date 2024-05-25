package org.amaap.troopsimulationgame.repository.impl.db.impl;

import org.amaap.troopsimulationgame.domain.model.entity.Trooper;
import org.amaap.troopsimulationgame.repository.impl.db.InMemoryDatabase;
import org.amaap.troopsimulationgame.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements InMemoryDatabase {
    private List<Trooper> troops = new ArrayList<>();
    private List<Trooper> troopers = new ArrayList<>();
    private List<Trooper> trainedTroopers = new ArrayList<>();
    private int archerCount = 0;
    private int barbarianCount = 0;

    @Override
    public void insertIntoTroopTable(Trooper trooper) throws InvalidTroopTypeException {
        troops.add(trooper);
    }

    @Override
    public List<Trooper> getTroops() {
        return troops;
    }

    @Override
    public void insertIntoBarrackTable(Trooper trooper) {
        troopers.add(trooper);
    }

    @Override
    public List<Trooper> getTroopers() {
        return troopers;
    }

    @Override
    public void save(List<Trooper> trainedTroops) {
        trainedTroopers.addAll(trainedTroops);
    }


    @Override
    public List<Trooper> getTrainedTroops() {
        return trainedTroopers;
    }

    @Override
    public void insertIntoArmyCampTable(List<Trooper> trooperList) {
        trainedTroopers.addAll(trooperList);
    }

    @Override
    public List<Trooper> getTrainedTroopsFromArmyCamp() {
        return trainedTroopers;
    }

    @Override
    public int getTrainedArcherCount() {
        return archerCount;
    }

    @Override
    public void setTrainedArcherCount(int count) {
        this.archerCount = count;
    }

    @Override
    public int getTrainedBarbarianCount() {
        return barbarianCount;
    }

    @Override
    public void setTrainedBarbarianCount(int count) {
        this.barbarianCount = count;
    }

}
