package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;

public class Archer extends Trooper {

    public Archer(int trainingTime, int trainingCost, String weapon) throws InvalidTroopTrainingTimeAndCostException, InvalidWeaponException {
        super(trainingTime, trainingCost, weapon);
    }

    @Override
    public String toString() {
        return "Archer{trainingTime=" + getTrainingTime() + ", trainingCost=" + getTrainingCost() + "'}";
    }

}
