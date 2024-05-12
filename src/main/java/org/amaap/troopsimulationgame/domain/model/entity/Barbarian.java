package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopDataException;

public class Barbarian extends Trooper {

    public Barbarian(int trainingTime, int trainingCost, String weapon) throws InvalidTroopDataException {
        super(trainingTime, trainingCost, weapon);
    }
    @Override
    public String toString() {
        return "Barbarian{trainingTime=" + getTrainingTime() + ", trainingCost=" + getTrainingCost() +  "'}";
    }
}
