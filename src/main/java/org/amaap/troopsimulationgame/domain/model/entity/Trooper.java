package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingTimeAndCostException;
import org.amaap.troopsimulationgame.service.exception.InvalidWeaponException;

import java.util.Objects;

import static org.amaap.troopsimulationgame.service.validator.TroopValidator.isInvalid;

public class Trooper {
    private final int trainingTime;
    private final int trainingCost;
    private final String weapon;

    public Trooper(int trainingTime, int trainingCost, String weapon) throws InvalidTroopTrainingTimeAndCostException, InvalidWeaponException {
        if (trainingCost <= 0) throw new InvalidTroopTrainingTimeAndCostException("" + trainingCost);
        if (trainingTime <= 0) throw new InvalidTroopTrainingTimeAndCostException("" + trainingTime);
        if (isInvalid(weapon)) throw new InvalidWeaponException(" " + weapon);
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;
        this.weapon = weapon;
    }


    public int getTrainingTime() {
        return trainingTime;
    }

    public int getTrainingCost() {
        return trainingCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper archer = (Trooper) o;
        return trainingTime == archer.trainingTime && trainingCost == archer.trainingCost && Objects.equals(weapon, archer.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingTime, trainingCost, weapon);
    }


}
