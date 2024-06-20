package org.amaap.troopsimulationgame.domain.model.entity;

import org.amaap.troopsimulationgame.service.exception.InvalidTroopTrainingCostException;

import java.util.Objects;

public class Trooper {
    private final int trainingTime;
    private final int trainingCost;
    private final String weapon;

    public Trooper(int trainingTime, int trainingCost, String weapon) throws InvalidTroopTrainingCostException {
        if (trainingCost <= 0) throw new InvalidTroopTrainingCostException("" + trainingCost);
        if (trainingTime <= 0) throw new InvalidTroopTrainingCostException("" + trainingTime);
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
