package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;

public class Barbarian extends Trooper {

    public Barbarian(int trainingTime, int trainingCost, String weapon) throws InvalidTroopTrainingTimeAndCostException, InvalidWeaponException {
        super(trainingTime, trainingCost, weapon);
    }
}
